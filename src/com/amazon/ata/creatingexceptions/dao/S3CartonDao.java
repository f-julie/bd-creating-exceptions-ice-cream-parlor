package com.amazon.ata.creatingexceptions.dao;

import com.amazon.ata.creatingexceptions.model.Carton;
import com.amazon.ata.creatingexceptions.model.Flavor;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Map;

/**
 * Represents a DAO for retrieving Carton details from S3.
 *
 * Note: Does not actually interact with S3. This class
 * exists to give participants practice migrating between DAOs.
 */
public class S3CartonDao implements CartonDao {
    private static final Map<String, Carton> CARTON_MAP = ImmutableMap.of(
        "vanilla", new Carton(new Flavor("vanilla"), 10),
        "chocolate", new Carton(new Flavor("chocolate"), 0));

    /**
     * Retrieves a carton from our datastore given a flavor.
     *
     * @param id - the name of the flavor to get a carton for.
     * @return the Carton matching the flavor given.
     */
    @Override
    public Carton getCarton(String id) throws AmazonS3Exception {
        if (CARTON_MAP.containsKey(id)) {
            return new Carton(CARTON_MAP.get(id));
        } else {
            throw new AmazonS3Exception("Requested file " + id + ".json does not exist.");
        }
    }

    /**
     * Saves a carton to our datastore
     *
     * @param carton - the Carton to save
     * @return the saved Carton
     * @throws NotImplementedException, since this is not implemented.
     */
    @Override
    public Carton saveCarton(Carton carton) {
        throw new NotImplementedException();
    }
}
