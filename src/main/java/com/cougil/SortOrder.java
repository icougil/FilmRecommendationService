package com.cougil;

public enum SortOrder {
    AVERAGE_RATE("avg_rate");

    private String name;

    SortOrder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
