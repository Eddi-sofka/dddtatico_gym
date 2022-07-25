package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.commands.CreateFrontDesk;
import com.zen.gymdomain.frontdesk.events.FrontDeskCreated;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.trainer.values.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateFrontDeskUseCaseTest {

    private CreateFrontDeskUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CreateFrontDeskUseCase();
    }

    @Test
    void createFrontDeskSuccessfully() {
//        given
//        FrontDeskID of
        FrontDeskID frontDeskID = FrontDeskID.of("fakeFrontDeskID");
//        Name
        Name name = new Name("Paola");
//        CreateFrontDesk command
        var command = new CreateFrontDesk(frontDeskID, name);
//        when
//        list of events
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
//        CreateFrontDesk created
        FrontDeskCreated frontDeskCreated = (FrontDeskCreated) domainEvents.get(0);
//        assert values
        assertEquals("Paola", frontDeskCreated.getName().value());
        assertEquals("fakeFrontDeskID", frontDeskCreated.aggregateRootId());
    }
}