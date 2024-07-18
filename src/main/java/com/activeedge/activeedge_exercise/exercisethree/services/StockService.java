package com.activeedge.activeedge_exercise.exercisethree.services;

import com.activeedge.activeedge_exercise.exercisethree.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();
    Stock getStockById(Long id);
    Stock createStock(Stock stock);
    Stock updateStockPrice(Long id, double newPrice);
}
