package com.company.atelier_manager.structure;

public class ExtraRequirement {
    private final long id;
    private String name;
    private double value;

    public ExtraRequirement(long id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
    public ExtraRequirement(String name, double value) {
        this.id = -1;
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
