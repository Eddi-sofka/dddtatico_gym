package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.commands.AddRoutine;
import com.zen.gymdomain.trainer.events.RoutineAdded;
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
class AddRoutineUseCaseTest {
    @InjectMocks
    private AddRoutineUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addRoutineToTrainerSuccessfully() {
//        given
        TrainerID trainerID = TrainerID.of("fakeTrainerID");
        Description description = new Description("routine test case#1");
        Type type = new Type(TypeEnum.CARDIO);
        var command = new AddRoutine(trainerID, description, type);

        Mockito.when(repository.getEventsBy("fakeTrainerID")).thenReturn(history());
        useCase.addRepository(repository);

//        when
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTrainerID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        var event = (RoutineAdded) domainEvents.get(0);
        assertEquals("routine test case#1", event.getDescription().value());
        assertEquals(TypeEnum.CARDIO, event.getType().value());
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