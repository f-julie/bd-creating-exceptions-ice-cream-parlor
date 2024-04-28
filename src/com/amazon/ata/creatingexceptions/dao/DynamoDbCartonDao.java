package com.amazon.ata.creatingexceptions.dao;

import com.amazon.ata.creatingexceptions.model.Carton;
import com.amazon.ata.creatingexceptions.model.Flavor;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * DAO for retrieving Carton details from DynamoDB.
 *
 * Note: Does not actually interact with DynamoDB. This class
 * exists to give you practice migrating between DAOs.
 */
public class DynamoDbCartonDao implements CartonDao {
    private Map<String, Carton> cartons;

    public DynamoDbCartonDao() {
        this.cartons = new HashMap<>();
        cartons.put("vanilla", new Carton(new Flavor("vanilla"), 10));
        cartons.put("chocolate", new Carton(new Flavor("chocolate"), 3));
    }

    /**
     * Retrieves a carton from our datastore given a flavor
     *
     * @param id - the flavor for which to retrieve a carton.
     * @return the Carton matching the flavor given
     *
     * @throws ResourceNotFoundException if no Carton for the reqyested
     * flavor is found.
     */
    @Override
    public Carton getCarton(String id) throws ResourceNotFoundException {
        if (cartons.containsKey(id)) {
            return new Carton(cartons.get(id));
        } else {
            throw new ResourceNotFoundException("Item with primary key [" + id + "] not found.");
        }
    }

    /**
     * Saves a carton to our datastore
     *
     * @param carton - the Carton to save
     * @return the saved Carton
     */
    public Carton saveCarton(Carton carton) {
        cartons.put(carton.getFlavor().getName(), carton);
        return carton;
    }
}
