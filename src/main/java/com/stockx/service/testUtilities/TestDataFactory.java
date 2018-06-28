package com.stockx.service.testUtilities;

import com.stockx.service.representation.Shoe;

import java.math.BigDecimal;
import java.util.Optional;

public class TestDataFactory {

    public static Shoe buildShoe() {
        Shoe shoe = new Shoe();

        shoe.setDisplay("Test Shoe");
        shoe.setKey("test-shoe");
        shoe.setTrueToSizeScore(3);

        return shoe;
    }

    public static Optional<BigDecimal> buildTrueToSizeScore() {
        return Optional.of(BigDecimal.valueOf(2.333456));
    }
}
