package com.activeedge.activeedge_exercise.controller;

import com.activeedge.activeedge_exercise.exercisethree.Stock;
import com.activeedge.activeedge_exercise.exercisethree.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Stock createStock(@RequestBody Stock stock) {
        return stockService.createStock(stock);
    }

    @PutMapping("/{id}")
    public Stock updateStockPrice(@PathVariable Long id, @RequestParam double newPrice) {
        return stockService.updateStockPrice(id, newPrice);
    }
}

