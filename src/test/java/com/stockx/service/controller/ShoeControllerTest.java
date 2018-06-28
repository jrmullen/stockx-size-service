package com.stockx.service.controller;

import com.stockx.service.entity.ShoeEntity;
import com.stockx.service.representation.Shoe;
import com.stockx.service.service.ShoeService;
import com.stockx.service.testUtilities.TestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoeControllerTest {

    @Mock
    ShoeService shoeService;

    @InjectMocks
    ShoeController underTest;

    private Shoe shoe;
    private Optional<BigDecimal> trueToSizeScore;

    @Before
    public void setUp() throws Exception {
        shoe = TestDataFactory.buildShoe();
        trueToSizeScore = TestDataFactory.buildTrueToSizeScore();
    }

    @Test
    public void createShoe() throws Exception {
        when(shoeService.createShoe(any())).thenReturn(new ShoeEntity());
        ResponseEntity response = underTest.createShoe(shoe);

        ResponseEntity expected = ResponseEntity.ok().build();

        assertEquals(expected, response);
    }

    @Test
    public void getTrueToSizeCalculation() throws Exception {
        when(shoeService.getTrueToSizeScoreForShoe(any())).thenReturn(trueToSizeScore);
        ResponseEntity response = underTest.getTrueToSizeCalculation("test-shoe");

        ResponseEntity expected = ResponseEntity.ok(BigDecimal.valueOf(2.333456));

        assertEquals(expected, response);
    }

}