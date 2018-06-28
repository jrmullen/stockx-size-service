package com.stockx.service.conversion;

import com.stockx.service.entity.ShoeEntity;
import com.stockx.service.representation.Shoe;

public class ShoeEntityToRepresentation {

    public Shoe convertToRepresentation(ShoeEntity entity) {
        Shoe shoe = new Shoe();

        shoe.setDisplay(entity.getDisplay());
        shoe.setKey(entity.getKey());
        shoe.setTrueToSizeScore(entity.getTrueToSizeScore());

        return shoe;
    }
}
