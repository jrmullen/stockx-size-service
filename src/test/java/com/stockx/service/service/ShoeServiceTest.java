package com.stockx.service.service;

import com.stockx.service.dao.SimpleDao;
import com.stockx.service.entity.ShoeEntity;
import com.stockx.service.representation.Shoe;
import com.stockx.service.testUtilities.TestDataFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShoeServiceTest {

    @Mock SimpleDao simpleDao;
    @Mock Query     trueToSizeQuery;

    @InjectMocks
    ShoeService underTest;


    private List<BigDecimal> resultList = new ArrayList<>();
    private Shoe shoe;

    @Before
    public void setUp() throws Exception {
        resultList.add(BigDecimal.valueOf(2.2222222));

        shoe = TestDataFactory.buildShoe();
    }

    @Test
    public void getTrueToSizeScoreForShoeTest() {
        when(simpleDao.nativeQuery("SELECT avg(true_to_size_score) FROM shoe WHERE key = :key")).thenReturn(trueToSizeQuery);
        when(trueToSizeQuery.setParameter("key", "test")).thenReturn(trueToSizeQuery);
        when(trueToSizeQuery.getResultList()).thenReturn(resultList);

        Optional<BigDecimal> actual = underTest.getTrueToSizeScoreForShoe("test");
        BigDecimal expected = BigDecimal.valueOf(2.2222222);

        assertEquals(expected, actual.get());
    }

    @Test
    public void createShoeTest() {
        when(simpleDao.create(any())).thenReturn(new ShoeEntity());

        ShoeEntity entity = underTest.createShoe(shoe);

        assertEquals(shoe.getDisplay(), entity.getDisplay());
        assertEquals(shoe.getKey(), entity.getKey());
        assertEquals(shoe.getTrueToSizeScore(), entity.getTrueToSizeScore());
    }
}