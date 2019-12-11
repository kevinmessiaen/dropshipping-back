package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.BasketDto;
import com.messiaen.dropshipping.service.IBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
}
