package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.StatisticRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "statisticRepository")
@Transactional
public class StatisticRepositoryImpl implements StatisticRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> statisticQueryByProductCount() {
        return entityManager.createNativeQuery(
                "select tab.product_ID , product.name , tab.cou \n" +
                        "FROM (select sum(count) cou, product_ID from element group by product_ID) tab\n" +
                        "join product on product.id = tab.product_ID;").getResultList();

    }

    @Override
    public List<Object[]> statisticQueryByProductPrice() {
        return entityManager.createNativeQuery(
                "select tab.product_ID , product.name , tab.cou*product.price \n" +
                        "FROM (select sum(count) cou, product_ID from element group by product_ID) tab\n" +
                        "join product on product.id = tab.product_ID;").getResultList();
    }
}
