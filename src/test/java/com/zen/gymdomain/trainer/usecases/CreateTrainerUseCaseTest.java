package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.commands.CreateTrainer;
import com.zen.gymdomain.trainer.events.TrainerCreated;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.TrainerID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateTrainerUseCaseTest {
    private CreateTrainerUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CreateTrainerUseCase();
    }

    @Test
    public void createTrainerSuccessfully() {
//        given
        TrainerID trainerID = TrainerID.of("fakeTrainerID");
        Name name = new Name("Juan");
        CreateTrainer command = new CreateTrainer(trainerID, name);
//        when
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        TrainerCreated trainerCreated = (TrainerCreated) domainEvents.get(0);
        assertEquals("fakeTrainerID", trainerCreated.aggregateRootId());
        assertEquals("Juan", trainerCreated.getName().value());

    }

}