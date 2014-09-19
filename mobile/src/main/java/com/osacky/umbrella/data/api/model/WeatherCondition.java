package com.osacky.umbrella.data.api.model;

public class WeatherCondition {
    private int id;
    private String main;
    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }

    public boolean isThunderStorm() {
        return id >= 200 && id <= 299;
    }

    public boolean isDrizzle() {
        return id >= 300 && id <= 399;
    }

    public boolean isRain() {
        return id >= 500 && id <= 599;
    }

    public boolean isSnow() {
        return id >= 600 && id <= 699;
    }

    public boolean isAtmosphere() {
        return id >= 700 && id <= 799;
    }

    public boolean isCloudy() {
        return id >= 800 && id <= 899;
    }

    public boolean isExtreme() {
        return id >= 900 && id <= 949;
    }

    public boolean isOther() {
        return id >= 950 && id <= 999;
    }

    public boolean isAnyRain() {
        return id >= 200 && id <= 599;
    }

    public int getId() {
        return id;
    }

    @Override public String toString() {
        return "WeatherCondition{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherCondition condition = (WeatherCondition) o;

        return id == condition.id && !(description != null ? !description.equals(condition
                .description) : condition.description != null) && !(icon != null ? !icon.equals
                (condition.icon) : condition.icon != null) && !(main != null ? !main.equals
                (condition.main) : condition.main != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (main != null ? main.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }
}
