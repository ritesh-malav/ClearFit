package org.example;

import java.util.HashSet;
import java.util.Set;

public class Workout {
    public String name;
    public Integer startTime;
    public Integer endTime;
    private Integer availableSlots;
    private Set<String> sessions;

    Workout(String name, Integer startTime, Integer endTime, Integer availableSlots) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableSlots = availableSlots;
        this.sessions = new HashSet<>();
    }

    public String getAvailability() {
        return this.name + " " + this.startTime + " " +
                this.endTime + " " + (this.availableSlots - sessions.size());
    }

    public void bookSession(String person) {
        if (this.sessions.contains(person)) {
            throw new RuntimeException("Person has already booked the session");
        }
        if (this.sessions.size() == availableSlots) {
            throw new RuntimeException("Session is full");
        }
        this.sessions.add(person);
    }

    public void cancelSession(String person) {
        if (!this.sessions.contains(person)) {
            throw new RuntimeException("Person does not have booking in the session");
        }
        sessions.remove(person);
    }
}
