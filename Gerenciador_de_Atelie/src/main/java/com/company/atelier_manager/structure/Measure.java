package com.company.atelier_manager.structure;

public class Measure {
    private final long id;
    private String name;
    private String size;

    public Measure(long id, String name, String size){
        this.id = id;
        this.name = name;
        this.size = size;
    }
    public Measure(String name, String size){
        this.id = -1;
        this.name = name;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
