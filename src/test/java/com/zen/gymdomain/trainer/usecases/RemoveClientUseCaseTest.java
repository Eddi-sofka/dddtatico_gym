package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.commands.RemoveClient;
import com.zen.gymdomain.trainer.commands.UpdateClientFitnessLevel;
import com.zen.gymdomain.trainer.entities.Client;
import com.zen.gymdomain.trainer.events.ClientAdded;
import com.zen.gymdomain.trainer.events.ClientFitnessLevelUpdated;
import com.zen.gymdomain.trainer.events.ClientRemoved;
import com.zen.gymdomain.trainer.events.TrainerCreated;
import com.zen.gymdomain.trainer.values.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RemoveClientUseCaseTest {

    @InjectMocks
    private RemoveClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void removeClientFromTrainerSuccessfully() {

        TrainerID fakeTrainerID = TrainerID.of("fakeTrainerID");
        ClientID fakeClientID = ClientID.of("fakeClientID");

        var command = new RemoveClient(fakeTrainerID, fakeClientID);

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

        var event = (ClientRemoved) domainEvents.get(0);
        assertEquals("fakeClientID", event.getClientID().value());
        assertTrue(event.getWasDeleted());
        Mockito.verify(repository).getEventsBy("fakeTrainerID");
    }

}
