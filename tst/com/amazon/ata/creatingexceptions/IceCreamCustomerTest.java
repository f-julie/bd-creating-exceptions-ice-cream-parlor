package com.amazon.ata.creatingexceptions;

import com.amazon.ata.creatingexceptions.IceCreamCustomer;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IceCreamCustomerTest {

    @Test
    public void enjoyAnIceCreamScoop_flavorExists_returnsHappyResponse() {
        IceCreamCustomer underTest = new IceCreamCustomer();

        String result = underTest.enjoyAnIceCreamScoop("vanilla");

        assertEquals(IceCreamCustomer.HAPPY, result);
    }

    @Test
    public void enjoyAnIceCreamScoop_flavorDoesNotExist_returnsSadResponse() {
        IceCreamCustomer underTest = new IceCreamCustomer();

        String result = underTest.enjoyAnIceCreamScoop("unknownFlavor");

        assertEquals(IceCreamCustomer.SAD, result);
    }

    @Test
    public void enjoyAnIceCreamSundae_allFlavorsExist_returnsHappyResponse() {
        IceCreamCustomer underTest = new IceCreamCustomer();

        String result = underTest.enjoyAnIceCreamSundae(ImmutableList.of("vanilla", "chocolate"));

        assertEquals(IceCreamCustomer.HAPPY, result);
    }

    @Test
    public void enjoyAnIceCreamSundae_anyFlavorDoesNotExist_returnsSadResponse() {
        IceCreamCustomer underTest = new IceCreamCustomer();

        String result = underTest.enjoyAnIceCreamSundae(ImmutableList.of("vanilla", "unknownFlavor"));

        assertEquals(IceCreamCustomer.SAD, result);
    }
}
