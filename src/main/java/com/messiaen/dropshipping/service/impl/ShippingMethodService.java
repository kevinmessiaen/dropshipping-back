package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.model.BasketDto;
import com.messiaen.dropshipping.model.ShippingMethodDto;
import com.messiaen.dropshipping.repository.ShippingMethodRepository;
import com.messiaen.dropshipping.service.IShippingMethodService;
import com.messiaen.dropshipping.transformer.calculator.ShippingCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class ShippingMethodService implements IShippingMethodService {

    private final ShippingMethodRepository shippingMethodRepository;
    private final ShippingCalculator shippingCalculator;
    private final BasketService basketService;

    @Autowired
    public ShippingMethodService(ShippingMethodRepository shippingMethodRepository, ShippingCalculator shippingCalculator, BasketService basketService) {
        this.shippingMethodRepository = shippingMethodRepository;
        this.shippingCalculator = shippingCalculator;
        this.basketService = basketService;
    }

    @Override
    public Collection<ShippingMethodDto> findAvailableShippingMethods(String uuid) {
        BasketDto basket = basketService.findById(uuid).orElse(null);
        if (basket == null)
            return Collections.emptyList();

        return shippingCalculator.available(shippingMethodRepository.findAll(), basket);
    }
}
