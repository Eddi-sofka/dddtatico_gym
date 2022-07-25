package com.zen.gymdomain.nutritionist.commands;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.events.NutritionistCreated;
import com.zen.gymdomain.nutritionist.usecases.CreateNutritionistUseCase;
import com.zen.gymdomain.nutritionist.usecases.commands.CreateNutritionist;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.trainer.values.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateNutritionistTest {

    private CreateNutritionistUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CreateNutritionistUseCase();
    }

    @Test
    public void createNutritionistSuccessfully() {
//        given
//        nutritionistID of
        NutritionistID nutritionistID = NutritionistID.of("fakeNutritionistID");
//        name
        Name name = new Name("Beatriz");
//        createNutritionist command
        var command = new CreateNutritionist(nutritionistID, name);
//        when
//        list of events
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        assert
//        nutritionist created
        NutritionistCreated nutritionistCreated = (NutritionistCreated) domainEvents.get(0);
//        assert values
        assertEquals("Beatriz", nutritionistCreated.getName().value());
        assertEquals("fakeNutritionistID", nutritionistCreated.aggregateRootId());

    }
}