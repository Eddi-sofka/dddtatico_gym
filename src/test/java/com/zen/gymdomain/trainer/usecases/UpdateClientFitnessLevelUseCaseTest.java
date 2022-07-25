package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.commands.UpdateClientFitnessLevel;
import com.zen.gymdomain.trainer.events.ClientAdded;
import com.zen.gymdomain.trainer.events.ClientFitnessLevelUpdated;
import com.zen.gymdomain.trainer.events.TrainerCreated;
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
class UpdateClientFitnessLevelUseCaseTest {

    @InjectMocks
    private UpdateClientFitnessLevelUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateClientFitnessLevelSuccessfully() {

        TrainerID fakeTrainerID = TrainerID.of("fakeTrainerID");
        ClientID fakeClientID = ClientID.of("fakeClientID");
        FitnessLevel updatedFitnessLevel = new FitnessLevel(FitnessLevelEnum.HIGH);

        var command = new UpdateClientFitnessLevel(fakeTrainerID, fakeClientID, updatedFitnessLevel);

        Mockito.when(repository.getEventsBy("fakeTrainerID")).thenReturn(List.of(
                new TrainerCreated(new Name("Juan")),
                new ClientAdded(ClientID.of("fakeClientID"), new Name("david"), new FitnessLevel(FitnessLevelEnum.MEDIUM), new PhoneNumber("312987657")),
                new ClientAdded(ClientID.of("anotherClient"), new Name("Luis"), new FitnessLevel(FitnessLevelEnum.MEDIUM), new PhoneNumber("312777757"))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("fakeTrainerID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClientFitnessLevelUpdated) domainEvents.get(0);
        assertEquals(FitnessLevelEnum.HIGH, event.getFitnessLevel().value());
        assertEquals("fakeClientID", event.getClientID().value());
        Mockito.verify(repository).getEventsBy("fakeTrainerID");
    }

}