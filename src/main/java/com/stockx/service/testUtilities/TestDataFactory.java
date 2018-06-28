package com.stockx.service.testUtilities;

import com.stockx.service.representation.Shoe;

public class TestDataFactory {

    public static Shoe buildShoe() {
        Shoe shoe = new Shoe();

        shoe.setDisplay("Test Shoe");
        shoe.setKey("test-shoe");
        shoe.setTrueToSizeScore(3);

        return shoe;
    }
}
