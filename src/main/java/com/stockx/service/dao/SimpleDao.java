package com.stockx.service.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

import static java.text.MessageFormat.format;

@Repository
public class SimpleDao {

    @PersistenceContext
    EntityManager em;

    public <T, K> T findOne(Class<T> clazz, K id) {
        return em.find(clazz, id);
    }

    public <T, K> Optional<T> findOneOptionalByField(Class<T> clazz, String field, K value) {
        String q = format("FROM {0} WHERE {1} = :value", clazz.getName(), field);
        return em.createQuery(q).setParameter("value", value).setMaxResults(1).getResultList().stream().findFirst();
    }

    public <T> List<T> findAll(Class<T> clazz) {
        return em.createQuery(format("FROM {0}", clazz.getName())).getResultList();
    }

    public void flush() {
        em.flush();
    }

    public Query createQuery(String query) {
        return em.createQuery(query);
    }

    public Query nativeQuery(String q) {
        return em.createNativeQuery(q);
    }
}
