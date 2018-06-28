package com.stockx.service.controller;

import com.stockx.service.representation.Shoe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/shoe")
public class ShoeController {

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<?> createShoe(@Valid @RequestBody Shoe shoe) {


        return ResponseEntity.ok("It worked!");
    }

    @RequestMapping(value = "/true-to-size/{key}", method = RequestMethod.GET)
    public ResponseEntity<?> getTrueToSizeCalculation(@PathVariable String key){


        return ResponseEntity.ok("It worked!");
    }

}
