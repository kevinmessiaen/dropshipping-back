package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.ProductDto;
import com.messiaen.dropshipping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    private ResponseEntity<Collection<ProductDto>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

}
