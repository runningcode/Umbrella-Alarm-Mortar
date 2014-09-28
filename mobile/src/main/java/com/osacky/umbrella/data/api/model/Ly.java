package com.osacky.umbrella.data.api.model;

import java.util.List;

public class Ly {
    private String summary;
    private String icon;
    private List<Condition> data;

    public String getIcon() {
        return icon;
    }

    public String getSummary() {
        return summary;
    }

    public List<Condition> getData() {
        return data;
    }
}
