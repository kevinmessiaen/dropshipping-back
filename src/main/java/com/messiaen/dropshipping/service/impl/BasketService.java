package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.model.BasketDto;
import com.messiaen.dropshipping.repository.BasketRepository;
import com.messiaen.dropshipping.service.IBasketService;
import com.messiaen.dropshipping.transformer.BasketTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BasketService implements IBasketService {

    private final BasketTransformer basketTransformer;

    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketTransformer basketTransformer, BasketRepository basketRepository) {
        this.basketTransformer = basketTransformer;
        this.basketRepository = basketRepository;
    }

    @Override
    public Optional<BasketDto> findById(String uuid) {
        return basketRepository.findById(UUID.fromString(uuid))
                .map(basketTransformer::transformToDto);
    }
}
