package com.amazon.ata.creatingexceptions.model;

/**
 * POJO Representing a scoop of a given flavor of ice cream.
 */
public class Scoop {

    private Flavor flavor;

    public Scoop(Flavor flavor) {
        this.flavor = flavor;
    }

    public Flavor getFlavor() {
        return flavor;
    }
}
