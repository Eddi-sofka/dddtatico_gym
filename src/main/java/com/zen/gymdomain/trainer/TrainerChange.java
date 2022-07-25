package com.zen.gymdomain.trainer;

import co.com.sofka.domain.generic.EventChange;
import com.zen.gymdomain.trainer.entities.Client;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.events.*;
import com.zen.gymdomain.trainer.values.ClientID;

import java.util.HashSet;

public class TrainerChange extends EventChange {
    TrainerChange(Trainer trainer) {
        apply((TrainerCreated event) -> {
            trainer.name = event.getName();
            trainer.clientSet = new HashSet<>();
        });

        apply((ClientAdded event) -> {
            Client client = new Client(event.getClientID(), event.getName(), event.getFitnessLevel(), event.getPhoneNumber());
            trainer.clientSet.add(client);
        });

        apply((ClientRemoved event) -> {
            trainer.clientSet.removeIf(client -> client.identity().equals(event.getClientID()));
        });

        apply((ClientFitnessLevelUpdated event) -> {
            Client client = trainer.findClientById(event.getClientID()).orElseThrow();
            client.updateFitnessLevel(event.getFitnessLevel());
        });

        apply((ClientPhoneNumberUpdated event) -> {
            Client client = trainer.findClientById(event.getClientID()).orElseThrow();
            client.updatePhoneNumber(event.getPhoneNumber());
        });

        apply((ClientNameUpdated event) -> {
            Client client = trainer.findClientById(event.getClientID()).orElseThrow();
            client.updateName(event.getName());
        });

        apply((RoutineAdded event) -> {
            trainer.routine = new Routine(event.getRoutineID(), event.getDescription(), event.getType());
        });

        apply((RoutineDescriptionUpdated event) -> {
            trainer.routine.updateDescription(event.getDescription());
        });

        apply((RoutineIsCompletedUpdated event) -> {
            trainer.routine.updateIsCompleted(event.getIsCompleted());
        });

        apply((RoutineTypeUpdated event) -> {
            trainer.routine.updateType(event.getType());
        });
    }
}
