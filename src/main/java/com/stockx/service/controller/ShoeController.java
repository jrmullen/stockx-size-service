package com.stockx.service.controller;

import com.stockx.service.entity.ShoeEntity;
import com.stockx.service.representation.Shoe;
import com.stockx.service.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/shoe")
public class ShoeController {

    @Autowired
    ShoeService shoeService;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> createShoe(@Valid @RequestBody Shoe shoe) {

        ShoeEntity entity = shoeService.createShoe(shoe);

        if (entity != null) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/true-to-size/{key}", method = RequestMethod.GET)
    public ResponseEntity<?> getTrueToSizeCalculation(@PathVariable String key) {
        try {
            Optional<BigDecimal> score = shoeService.getTrueToSizeScoreForShoe(key);

            if (score.isPresent()) {
                return ResponseEntity.ok(score.get());
            }

            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.notFound().build();
    }

}
