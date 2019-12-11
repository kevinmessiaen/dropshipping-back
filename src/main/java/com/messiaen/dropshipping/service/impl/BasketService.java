package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.entity.Basket;
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

    @Override
    public Optional<BasketDto> createBasket(BasketDto basket) {
        return Optional.of(basketTransformer.transformToDto(
                basketRepository.save(basketTransformer.transformToEntity(basket))));
    }

    @Override
    public Optional<BasketDto> updateBasket(String uuid, BasketDto basket) {
        Basket entity = basketRepository.findById(UUID.fromString(uuid)).orElse(null);
        if (entity == null)
            return Optional.empty();

        entity.setContent(basketTransformer.transformToEntity(basket).getContent());
        entity.getContent().forEach((e) -> e.getId().setBasket(entity));
        return Optional.of(basketTransformer.transformToDto(basketRepository.save(entity)));
    }
}
