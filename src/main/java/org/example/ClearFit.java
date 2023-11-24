package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClearFit {

    private List<Center> centers = new ArrayList<>();
    private Set<String> users = new HashSet<>();


    public void addCenter(String name) {
        for (Center center : centers) {
            if (center.name.equals(name)) {
                throw new RuntimeException("Center already exists");
            }
        }
        centers.add(new Center(name));
    }

    public void addCentreTimings(String name, List<Timing> timings) {
        Center center = getCenter(name);
        center.addCenterTimings(timings);
    }

    public void addCentreActivities(String name, List<String> activities) {
        Center center = getCenter(name);
        center.addCenterActivities(activities);
    }

    private Center getCenter(String name) {
        for (Center center : this.centers) {
            if (center.name.equals(name)) {
                return center;
            }
        }
        throw new RuntimeException("Center does not exist");
    }

    public void addWorkout(String name, String workout,
                           Integer startTime, Integer endTime, Integer availableSlots) {
        Center center = getCenter(name);
        center.addWorkout(workout, startTime, endTime, availableSlots);
    }

    public void register(String name) {
        if (users.contains(name)) {
            throw new RuntimeException("User already registered");
        }
        users.add(name);
    }

    public List<String> viewWorkoutAvailability(String name) {
        List<String> availability = new ArrayList<>();
        for (Center center : centers) {
            Workout workout = center.viewWorkoutAvailability(name);
            if (workout == null) {
                continue;
            }
            availability.add(center.name + " " + workout.getAvailability());
        }
        return availability;
    }

    public void bookSession(String person, String centerName, String workout) {
        Center center = getCenter(centerName);
        center.bookSession(person, workout);
    }

    public void cancelSession(String person, String centerName, String workout) {
        Center center = getCenter(centerName);
        center.cancelSession(person, workout);
    }
}
