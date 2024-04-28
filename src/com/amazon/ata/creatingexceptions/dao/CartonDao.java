package com.amazon.ata.creatingexceptions.dao;

import com.amazon.ata.creatingexceptions.model.Carton;

/**
 * DAO for retrieving Carton details.
*/
public interface CartonDao {

    /**
     * Retrieves a carton from our datastore given a flavor.
     *
     * @param id - the name of the flavor to get a carton for.
     * @return the Carton matching the flavor given.
     */
    public Carton getCarton(String id) throws RuntimeException;

    /**
     * Saves a carton to our datastore
     *
     * @param carton - the Carton to save
     * @return the saved Carton
     */
    public Carton saveCarton(Carton carton);
}
