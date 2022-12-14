package com.messiaen.dropshipping.service;

import com.messiaen.dropshipping.entity.Basket;
import com.messiaen.dropshipping.model.BasketDto;

import java.security.Principal;
import java.util.Optional;

public interface IBasketService {

    Optional<BasketDto> findById(String uuid);

    Optional<BasketDto> createBasket(BasketDto basket);

    Optional<BasketDto> updateBasket(String uuid, BasketDto basket);

}
