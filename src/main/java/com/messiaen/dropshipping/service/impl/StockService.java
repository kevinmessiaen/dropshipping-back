package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.entity.Stock;
import com.messiaen.dropshipping.repository.StockRepository;
import com.messiaen.dropshipping.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockService implements IStockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Map<Integer, Boolean> updateBasketInStock(Map<Integer, Short> quantities, LocalDateTime basketValidity) {
        stockRepository.updateInStock(quantities.keySet(), basketValidity);
        Collection<Stock> stocks = stockRepository.findAllById(quantities.keySet());

        Map<Integer, Boolean> result = new HashMap<>();
        stocks.forEach(stock -> {
            Short quantity = quantities.get(stock.getId());
            if (quantity > stock.getQuantity() - stock.getInBasket()) {
                result.put(stock.getId(), false);
            } else {
                stock.setInBasket(stock.getInBasket() + quantity);
                result.put(stock.getId(), true);
            }
        });
        stockRepository.saveAll(stocks.stream().filter(stock -> result.get(stock.getId())).collect(Collectors.toList()));
        return result;
    }

}
