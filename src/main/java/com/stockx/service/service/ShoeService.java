package com.stockx.service.service;

import com.stockx.service.dao.SimpleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ShoeService {

    private SimpleDao simpleDao;

    @Autowired
    public ShoeService(SimpleDao simpleDao) {
        this.simpleDao = simpleDao;
    }

    public Optional<BigDecimal> getTrueToSizeScoreForShoe(String key) {
        Query q = simpleDao.nativeQuery("SELECT avg(true_to_size_score) FROM shoe WHERE key = :key");
        q.setParameter("key", key);
        List result = q.getResultList();

        if (result.isEmpty()) {
            return Optional.empty();
        }

        BigDecimal average = (BigDecimal) result.get(0);

        return Optional.of(average);
    }
}
