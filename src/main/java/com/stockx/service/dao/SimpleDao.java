package com.stockx.service.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class SimpleDao {

    @PersistenceContext
    EntityManager em;

    public <T> T create(T t) {
        em.persist(t);
        return t;
    }

    public Query nativeQuery(String q) {
        return em.createNativeQuery(q);
    }
}
