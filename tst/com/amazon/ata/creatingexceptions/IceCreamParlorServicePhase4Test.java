package com.amazon.ata.creatingexceptions;

import com.amazon.ata.creatingexceptions.IceCreamParlorService;
import com.amazon.ata.creatingexceptions.dao.DynamoDbCartonDao;
import com.amazon.ata.creatingexceptions.exception.NoSuchFlavorException;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class IceCreamParlorServicePhase4Test {
    private static final String UNKNOWN_FLAVOR = "unknownFlavor";

    @Mock
    private DynamoDbCartonDao cartonDao;

    @InjectMocks
    private IceCreamParlorService iceCreamParlorService;

    @BeforeEach
    public void setup(){
        initMocks(this);
    }

    @Test
    public void getScoop_noSuchFlavor_throwsNoSuchFlavorException() {
        // GIVEN
        when(cartonDao.getCarton(UNKNOWN_FLAVOR)).thenThrow(ResourceNotFoundException.class);

        // WHEN + THEN
        assertThrows(NoSuchFlavorException.class,
                     () -> iceCreamParlorService.getScoop(UNKNOWN_FLAVOR),
                     "Expected NoSuchFlavorException when requesting a scoop for a flavor that does not exist!");
    }

    @Test
    public void getSundae_noSuchFlavor_throwsNoSuchFlavorException() {
        // GIVEN
        when(cartonDao.getCarton(UNKNOWN_FLAVOR)).thenThrow(ResourceNotFoundException.class);

        // WHEN + THEN
        assertThrows(NoSuchFlavorException.class,
                     () -> iceCreamParlorService.getSundae(Collections.singletonList(UNKNOWN_FLAVOR)),
                     "Expected getSundae to throw when requesting a flavor that does not exist!");
    }
}
