package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.commands.AddClient;
import com.zen.gymdomain.trainer.events.ClientAdded;
import com.zen.gymdomain.trainer.events.TrainerCreated;
import com.zen.gymdomain.trainer.values.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {

    @InjectMocks
    private AddClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addClientToTrainerSuccessfully() {
//        given
        TrainerID trainerID = TrainerID.of("fakeTrainerID");
        Name name = new Name("Maria");
        FitnessLevel fitnessLevel = new FitnessLevel(FitnessLevelEnum.HIGH);
        PhoneNumber phoneNumber = new PhoneNumber("312987657");
        var command = new AddClient(trainerID, name, fitnessLevel, phoneNumber);

        when(repository.getEventsBy("fakeTrainerID")).thenReturn(history());
        useCase.addRepository(repository);

//        when
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTrainerID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        assert
        var event = (ClientAdded) events.get(0);
        assertEquals("Maria", event.getName().value());
        assertEquals("312987657", event.getPhoneNumber().value());
        assertEquals(FitnessLevelEnum.HIGH, event.getFitnessLevel().value());
        Mockito.verify(repository).getEventsBy("fakeTrainerID");
    }

    private List<DomainEvent> history() {
        TrainerID trainerID = TrainerID.of("fakeTrainerID");
        Name name = new Name("Juan");
        var event = new TrainerCreated(name);
        event.setAggregateRootId(trainerID.value());
        return List.of(event);
    }

}