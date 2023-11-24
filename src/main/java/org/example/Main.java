package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Clearfit!!!");

        ClearFit clearFit = new ClearFit();
        clearFit.addCenter("Koramangala");
        List<Timing> timings = new ArrayList<>();
        timings.add(new Timing(6, 9));
        timings.add(new Timing(18, 21));
        clearFit.addCentreTimings("Koramangala", timings);
        List<String> activities = new ArrayList<>();
        activities.add("Weights");
        activities.add("Cardio");
        activities.add("Yoga");
        activities.add("Swimming");
        clearFit.addCentreActivities("Koramangala", activities);

        clearFit.addCenter("Bellandur");
        timings.clear();
        timings.add(new Timing(7, 10));
        timings.add(new Timing(18, 22));
        clearFit.addCentreTimings("Bellandur", timings);
        activities.clear();
        activities.add("Weights");
        activities.add("Cardio");
        activities.add("Yoga");
        clearFit.addCentreActivities("Bellandur", activities);

        clearFit.addWorkout("Koramangala", "Weights", 6, 7, 100);
        clearFit.addWorkout("Koramangala", "Cardio", 7, 8, 150);
        clearFit.addWorkout("Koramangala", "Yoga", 8, 9, 200);
        clearFit.addWorkout("Bellandur", "Weights", 18, 19, 100);
        clearFit.addWorkout("Bellandur", "Cardio", 20, 21, 100);
        clearFit.addWorkout("Bellandur", "Yoga", 21, 22, 100);
        clearFit.addWorkout("Bellandur", "Swimming", 17, 18, 100);

        clearFit.register("Vaibhav");
        List<String> availability = clearFit.viewWorkoutAvailability("Weights");
        System.out.println(availability);
        clearFit.bookSession("Vaibhav", "Koramangala", "Weights");
        availability = clearFit.viewWorkoutAvailability("Weights");
        System.out.println(availability);
        clearFit.cancelSession("Vaibhav", "Koramangala", "Weights");
        availability = clearFit.viewWorkoutAvailability("Weights");
        System.out.println(availability);
    }
}