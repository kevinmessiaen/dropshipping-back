package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.model.CategoryDto;
import com.messiaen.dropshipping.repository.CategoryRepository;
import com.messiaen.dropshipping.service.ICategoryService;
import com.messiaen.dropshipping.transformer.entity.CategoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryTransformer categoryTransformer;

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryTransformer categoryTransformer, CategoryRepository categoryRepository) {
        this.categoryTransformer = categoryTransformer;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Collection<CategoryDto> findAll() {
        return categoryTransformer.transformToDto(categoryRepository.findAll());
    }

}
