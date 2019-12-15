package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.BasketDto;
import com.messiaen.dropshipping.model.UserDto;
import com.messiaen.dropshipping.service.IBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
public class BasketController {

    private final IBasketService basketService;

    @Autowired
    public BasketController(IBasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/basket/{uuid}")
    private ResponseEntity<BasketDto> findById(@PathVariable String uuid) {
        return ResponseEntity.of(basketService.findById(uuid));
    }

    @PostMapping("/basket")
    private ResponseEntity<BasketDto> create(@RequestBody @Valid BasketDto basket) {
        return ResponseEntity.of(basketService.createBasket(basket));
    }

    @PutMapping("/basket/{uuid}")
    private ResponseEntity<BasketDto> update(@PathVariable String uuid, @RequestBody @Valid BasketDto basket) {
        return ResponseEntity.of(basketService.updateBasket(uuid, basket));
    }
}
