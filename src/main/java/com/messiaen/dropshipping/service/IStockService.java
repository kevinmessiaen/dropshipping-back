package com.messiaen.dropshipping.service;

import java.time.LocalDateTime;
import java.util.Map;

public interface IStockService {

    Map<Integer, Boolean> updateBasketInStock(Map<Integer, Short> quantities, LocalDateTime basketValidity);

}
