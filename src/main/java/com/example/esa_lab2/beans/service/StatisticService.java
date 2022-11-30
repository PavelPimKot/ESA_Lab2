package com.example.esa_lab2.beans.service;

import java.io.IOException;
import java.util.List;

public interface StatisticService {

    void writeSalesStatisticInFile(String fileUrl, String fileName) throws IOException;

    List<Object[]> statisticQueryByProductCount();

    List<Object[]> statisticQueryByProductPrice();
}
