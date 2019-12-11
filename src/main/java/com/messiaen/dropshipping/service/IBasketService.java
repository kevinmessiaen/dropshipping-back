package com.messiaen.dropshipping.service;

import com.messiaen.dropshipping.model.BasketDto;

import java.util.Optional;

public interface IBasketService {

    Optional<BasketDto> findById(String uuid);

}
