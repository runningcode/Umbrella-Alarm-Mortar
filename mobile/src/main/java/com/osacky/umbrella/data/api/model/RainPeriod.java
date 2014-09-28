package com.osacky.umbrella.data.api.model;

import org.joda.time.DateTime;

public class RainPeriod {
    private final DateTime start;
    private DateTime end;
    private final String condition;

    public RainPeriod(DateTime start, String condition) {
        this.start = start;
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

    public String getCondition() {
        return condition;
    }

    @Override public String toString() {
        return "RainPeriod{" +
                "start=" + start +
                ", end=" + end +
                ", condition='" + condition + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RainPeriod period = (RainPeriod) o;

        return condition.equals(period.condition) && end.equals(period.end) && start.equals
                (period.start);

    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + condition.hashCode();
        return result;
    }
}
