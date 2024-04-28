package com.amazon.ata.creatingexceptions.model;

import java.util.List;

/**
 * POJO Representing an ice cream sundae, composed of multiple flavors.
 */
public class Sundae {

    List<Flavor> flavors;

    public Sundae(List<Flavor> flavors) {
        this.flavors = flavors;
    }

    public List<Flavor> getFlavors() {
        return flavors;
    }

    public void setFlavors(List<Flavor> flavors) {
        this.flavors = flavors;
    }
}
