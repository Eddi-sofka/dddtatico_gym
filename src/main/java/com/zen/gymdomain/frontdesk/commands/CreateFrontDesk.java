package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.trainer.values.Name;

public class CreateFrontDesk extends Command {


    private final FrontDeskID entityId;
    private final Name name;

    public CreateFrontDesk(FrontDeskID entityId, Name name) {
        this.entityId = entityId;
        this.name = name;
    }

    public FrontDeskID getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
