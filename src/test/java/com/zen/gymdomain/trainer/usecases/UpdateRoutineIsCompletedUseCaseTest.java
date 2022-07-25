package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.commands.UpdateRoutineDescription;
import com.zen.gymdomain.trainer.commands.UpdateRoutineIsCompleted;
import com.zen.gymdomain.trainer.events.*;
import com.zen.gymdomain.trainer.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UpdateRoutineIsCompletedUseCaseTest {
    @InjectMocks
    private UpdateRoutineIsCompletedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateRoutineIsCompletedSuccessfully() {
        TrainerID fakeTrainerID = TrainerID.of("fakeTrainerID");
        IsCompleted isCompleted = new IsCompleted(true);
        var command = new UpdateRoutineIsCompleted(fakeTrainerID, isCompleted);

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

        var event = (RoutineIsCompletedUpdated) domainEvents.get(0);
        assertEquals(true, event.getIsCompleted().value());
        Mockito.verify(repository).getEventsBy("fakeTrainerID");
    }
}