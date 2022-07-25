package com.zen.gymdomain.trainer;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.entities.Client;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.events.*;
import com.zen.gymdomain.trainer.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Trainer extends AggregateEvent<TrainerID> {
    protected Set<Client> clientSet;
    protected Routine routine;

    protected Name name;

    public Trainer(TrainerID entityId, Name name) {
        super(entityId);
        appendChange(new TrainerCreated(name)).apply();
    }

    private Trainer(TrainerID entityId) {
        super(entityId);
        subscribe(new TrainerChange(this));
    }

    public static Trainer from(TrainerID trainerID, List<DomainEvent> domainEvents) {
        Trainer trainer = new Trainer(trainerID);
        domainEvents.forEach(trainer::applyEvent);
        return trainer;
    }
//  events
    public void addClient(Name name, FitnessLevel fitnessLevel, PhoneNumber phoneNumber) {
        ClientID clientID = new ClientID();
        appendChange(new ClientAdded(clientID, name, fitnessLevel, phoneNumber)).apply();
    }

    public void removeClient(ClientID clientID) {
        appendChange(new ClientRemoved(clientID)).apply();
    }

    public void updateClientFitnessLevel(ClientID clientID, FitnessLevel fitnessLevel) {
        appendChange(new ClientFitnessLevelUpdated(clientID, fitnessLevel)).apply();
    }

    public void updateClientPhoneNumber(ClientID clientID, PhoneNumber phoneNumber) {
        appendChange(new ClientPhoneNumberUpdated(clientID, phoneNumber)).apply();
    }

    public void updateClientName(ClientID clientID, Name name) {
        appendChange(new ClientNameUpdated(clientID, name)).apply();
    }

    public void addRoutine(Description description, Type type) { //change this
        RoutineID routineID = new RoutineID();
        appendChange(new RoutineAdded(routineID, description, type)).apply();
    }

    public void updateRoutineDescription(Description description) {
        appendChange(new RoutineDescriptionUpdated(description)).apply();
    }

    public void updateRoutineIsCompleted(IsCompleted isCompleted) {
        appendChange(new RoutineIsCompletedUpdated(isCompleted)).apply();
    }

    public void updateRoutineType(Type type) {
        appendChange(new RoutineTypeUpdated(type)).apply();
    }

    //    findById methods
    protected Optional<Client> findClientById(ClientID clientID) {
        return this.clientSet.stream().filter(client -> client.identity().equals(clientID)).findFirst();
    }

    public Set<Client> getClientSet() {
        return clientSet;
    }

    public Routine getRoutine() {
        return routine;
    }

    public Name getName() {
        return name;
    }
}
