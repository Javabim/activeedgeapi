package com.activeedge.activeedge_exercise.exercisethree.services;

import com.activeedge.activeedge_exercise.exception.StockException;
import com.activeedge.activeedge_exercise.exercisethree.Stock;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    private List<Stock> stockList = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Create initial stocks
        stockList.add(new Stock(1L, "ABC Corp", 100.0, LocalDateTime.now(), LocalDateTime.now()));
        stockList.add(new Stock(2L, "XYZ Ltd", 150.0, LocalDateTime.now(), LocalDateTime.now()));
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockList;
    }

    @Override
    public Stock getStockById(Long id) {
        Optional<Stock> foundStock = stockList.stream()
                .filter(stock -> stock.getId().equals(id))
                .findFirst();
        if (foundStock.isPresent()) {
            return foundStock.get();
        } else {
            throw new StockException("Stock with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Stock createStock(Stock stock) {
        stock.setId(generateNextId());
        stock.setCreateDate(LocalDateTime.now());
        stock.setLastUpdate(LocalDateTime.now());
        stockList.add(stock);
        return stock;
    }

    @Override
    public Stock updateStockPrice(Long id, double newPrice) {
        Optional<Stock> foundStock = stockList.stream()
                .filter(stock -> stock.getId().equals(id))
                .findFirst();

        if (foundStock.isPresent()) {
            Stock stockToUpdate = foundStock.get();
            stockToUpdate.setCurrentPrice(newPrice);
            stockToUpdate.setLastUpdate(LocalDateTime.now());
            return stockToUpdate;
        } else {
            throw new StockException("Stock with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    private Long generateNextId() {
        return stockList.isEmpty() ? 1L : stockList.get(stockList.size() - 1).getId() + 1;
    }
}

