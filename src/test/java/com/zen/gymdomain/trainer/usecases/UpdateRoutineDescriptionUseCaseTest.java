package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.commands.UpdateClientPhoneNumber;
import com.zen.gymdomain.trainer.commands.UpdateRoutineDescription;
import com.zen.gymdomain.trainer.events.*;
import com.zen.gymdomain.trainer.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UpdateRoutineDescriptionUseCaseTest {
    @InjectMocks
    private UpdateRoutineDescriptionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateRoutineDescriptionSuccessfully() {
        TrainerID fakeTrainerID = TrainerID.of("fakeTrainerID");
        Description description = new Description("updated description");

        var command = new UpdateRoutineDescription(fakeTrainerID, description);

        Mockito.when(repository.getEventsBy("fakeTrainerID")).thenReturn(List.of(
                new TrainerCreated(new Name("Juan")),
                new RoutineAdded(RoutineID.of("fakeRoutine"), new Description("oldDescription"), new Type(TypeEnum.RESISTANCE)),
                new ClientAdded(ClientID.of("fakeClientID"), new Name("david"), new FitnessLevel(FitnessLevelEnum.MEDIUM), new PhoneNumber("312987657")),
                new ClientAdded(ClientID.of("anotherClient"), new Name("Luis"), new FitnessLevel(FitnessLevelEnum.MEDIUM), new PhoneNumber("312777757"))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeTrainerID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (RoutineDescriptionUpdated) domainEvents.get(0);
        assertEquals("updated description", event.getDescription().value());
        Mockito.verify(repository).getEventsBy("fakeTrainerID");
    }
}