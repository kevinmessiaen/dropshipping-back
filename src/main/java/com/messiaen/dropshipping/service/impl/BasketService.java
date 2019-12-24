package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.entity.Basket;
import com.messiaen.dropshipping.model.BasketDto;
import com.messiaen.dropshipping.repository.BasketRepository;
import com.messiaen.dropshipping.service.IBasketService;
import com.messiaen.dropshipping.transformer.entity.BasketTransformer;
import com.messiaen.dropshipping.utils.LocalDateTimeUtils;
import com.messiaen.dropshipping.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class BasketService implements IBasketService {

    private final BasketTransformer basketTransformer;
    private final BasketRepository basketRepository;
    private final StockService stockService;

    @Autowired
    public BasketService(BasketTransformer basketTransformer, BasketRepository basketRepository, StockService stockService) {
        this.basketTransformer = basketTransformer;
        this.basketRepository = basketRepository;
        this.stockService = stockService;
    }

    @Override
    public Optional<BasketDto> findById(String uuid) {
        if (!basketRepository.findById(UUID.fromString(uuid)).isPresent()) return Optional.empty();
        return basketRepository.fetchById(UUID.fromString(uuid)).map(wrapper -> {
            BasketDto dto = basketTransformer.transformToDto(wrapper.getBasket());
            updateBasket(dto, wrapper.getBasket());
            dto.setItems(wrapper.getItems());
            dto.setPrice(wrapper.getPrice());
            return dto;
        });
    }

    @Override
    @Transactional
    public Optional<BasketDto> createBasket(BasketDto basket) {
        updateBasket(basket, null);
        Map<Integer, Short> notInStock = basket.getNotInStock();
        basket = basketTransformer.transformToDto(basketRepository.save(basketTransformer.transformToEntity(basket)));

        if (basket != null)
            basket.setNotInStock(notInStock);

        return Optional.ofNullable(basket);
    }

    @Override
    @Transactional
    public Optional<BasketDto> updateBasket(String uuid, BasketDto basket) {
        BasketDto saved = update(uuid, basket);
        if (saved == null)
            return Optional.empty();

        Optional<BasketDto> result = findById(saved.getId());
        result.ifPresent(basketDto -> basketDto.setNotInStock(saved.getNotInStock()));

        return result;
    }

    private BasketDto update(String uuid, BasketDto basket) {
        Basket entity = basketRepository.findById(UUID.fromString(uuid)).orElse(null);
        if (entity == null)
            return null;

        updateBasket(basket, entity);
        Map<Integer, Short> notInStock = basket.getNotInStock();

        entity.setContent(basketTransformer.transformToEntity(basket).getContent());
        entity.getContent().forEach((e) -> e.getId().setBasket(basketTransformer.holdKey(entity.getId())));

        basket = basketTransformer.transformToDto(basketRepository.save(entity));
        if (basket != null)
            basket.setNotInStock(notInStock);

        return basket;
    }

    private void updateBasket(BasketDto newBasket, Basket oldBasket) {
        LocalDateTime keepBasketValidity = LocalDateTimeUtils.getBasketValidity();

        Map<Integer, Short> modifications = findModifiedProducts(newBasket, oldBasket, keepBasketValidity);
        Map<Integer, Boolean> validation = stockService.updateBasketInStock(modifications, keepBasketValidity);
        Map<Integer, Short> notInStock = modifications.entrySet().stream().filter(e -> !validation.get(e.getKey())).collect(MapUtils.toMap());

        if (notInStock.size() > 0)
            newBasket.setProducts(MapUtils.minusShortValues(newBasket.getProducts(), notInStock));
        newBasket.setNotInStock(notInStock);
    }

    private Map<Integer, Short> findModifiedProducts(BasketDto newBasket, Basket oldBasket, LocalDateTime keepBasketValidity) {
        if (newBasket.getProducts() == null)
            newBasket.setProducts(new HashMap<>());

        if (oldBasket == null ||
                oldBasket.getLastUpdate() == null
                || keepBasketValidity.isAfter(oldBasket.getLastUpdate()))
            return newBasket.getProducts();

        return MapUtils.minusShortValues(
                newBasket.getProducts(),
                basketTransformer.transformToDto(oldBasket).getProducts()).entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .collect(MapUtils.toMap());
    }
}
