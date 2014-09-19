package com.osacky.umbrella.data.api.model;

import org.joda.time.DateTime;

public class RainPeriod {

    private final DateTime start;
    private DateTime end;
    private int condition;

    public RainPeriod(DateTime start, int condition) {
        this.start = start;
        this.end = start.plusHours(3);
        this.condition = condition;
    }

    public void updateEnd(DateTime end) {
        this.end = end;
    }

    public DateTime getStart() {
        return start;
    }

    public DateTime getEnd() {
        return end;
    }

    public int getCondition() {
        return condition;
    }

    @Override public String toString() {
        return "RainPeriod{" +
                "start=" + start +
                ", end=" + end +
                ", condition=" + condition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RainPeriod period = (RainPeriod) o;

        return condition == period.condition && end.equals(period.end) && start.equals(period
                .start);

    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + condition;
        return result;
    }
}
