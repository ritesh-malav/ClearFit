package org.example;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;
import java.util.List;

public class Center {
    public String name;
    private List<Timing> timings;
    private List<String> activities;
    private List<Workout> workouts;

    Center(String name) {
        this.name = name;
        this.timings = new ArrayList<>();
        this.activities = new ArrayList<>();
        this.workouts = new ArrayList<>();
    }

    public void addCenterTimings(List<Timing> timings) {
        this.timings.addAll(timings);
    }

    public void addCenterActivities(List<String> activities) {
        this.activities.addAll(activities);
    }

    public void addWorkout(String name, Integer startTime, Integer endTime, Integer availableSlots) {
        boolean isTimingAvailable = false;
        for (Timing timing : this.timings) {
            if (timing.startTime <= startTime && timing.endTime >= endTime) {
                isTimingAvailable = true;
                break;
            }
        }
        if (!isTimingAvailable) {
            throw new RuntimeException("Center does not have this timing");
        }

        boolean isAnotherWorkoutScheduledInThisTiming = false;
        for (Workout workout : this.workouts) {
            if ((workout.startTime > startTime && workout.startTime < endTime) ||
                    (workout.endTime > startTime && workout.endTime < endTime) ||
                    (workout.startTime == startTime && workout.endTime == endTime)) {
                isAnotherWorkoutScheduledInThisTiming = true;
                break;
            }
        }

        if (isAnotherWorkoutScheduledInThisTiming) {
            throw new RuntimeException("Center already has another workout in this timing");
        }

        Workout workout = new Workout(name, startTime, endTime, availableSlots);
        this.workouts.add(workout);
    }

    private Workout getWorkout(String name) {
        for (Workout workout : workouts) {
            if (workout.name.equals(name)) {
                return workout;
            }
        }
        throw new RuntimeException("Workout does not exist");
    }

    public Workout viewWorkoutAvailability(String name) {
        for (Workout workout : workouts) {
            if (workout.name.equals(name)) {
                return workout;
            }
        }
        return null;
    }

    public void bookSession(String person, String workoutName) {
        Workout workout = getWorkout(workoutName);
        workout.bookSession(person);
    }

    public void cancelSession(String person, String workoutName) {
        Workout workout = getWorkout(workoutName);
        workout.cancelSession(person);
    }
}
