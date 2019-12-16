package com.messiaen.dropshipping.controller;

import com.messiaen.dropshipping.model.CategoryDto;
import com.messiaen.dropshipping.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CategoryController {

    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    private ResponseEntity<Collection<CategoryDto>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

}
