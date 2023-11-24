package org.example;

public class Timing {
    public Integer startTime;
    public Integer endTime;

    Timing(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Timing{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
