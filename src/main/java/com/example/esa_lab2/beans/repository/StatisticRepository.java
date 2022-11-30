package com.example.esa_lab2.beans.repository;

import java.util.List;

public interface StatisticRepository {
    List<Object[]> statisticQueryByProductCount();

    List<Object[]> statisticQueryByProductPrice();
}
