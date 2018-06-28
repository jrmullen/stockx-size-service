package com.stockx.service.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SimpleDaoTest {
    @Mock
    EntityManager entityManager;

    @InjectMocks
    SimpleDao simpleDao;

    Object object = new Object();

    @Test
    public void createTest() {
        simpleDao.create(object);
        verify(entityManager).persist(object);
    }

}