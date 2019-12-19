package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.ShippingMethodDto;
import com.messiaen.dropshipping.service.IShippingMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ShippingMethodController {

    private final IShippingMethodService shippingMethodService;

    @Autowired
    public ShippingMethodController(IShippingMethodService shippingMethodService) {
        this.shippingMethodService = shippingMethodService;
    }

    @GetMapping("/shipping/basket/{uuid}")
    private ResponseEntity<Collection<ShippingMethodDto>> findAvailableShippingMethods(@PathVariable String uuid) {
        return ResponseEntity.ok(shippingMethodService.findAvailableShippingMethods(uuid));
    }
}
