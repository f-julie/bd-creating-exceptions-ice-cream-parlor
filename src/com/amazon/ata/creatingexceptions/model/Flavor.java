package com.amazon.ata.creatingexceptions.model;

/**
 * POJO Representing a flavor of ice cream.
 */
public class Flavor {

    private String name;

    public Flavor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
