package com.messiaen.dropshipping.service.impl;

import com.messiaen.dropshipping.model.ProductDto;
import com.messiaen.dropshipping.repository.ProductRepository;
import com.messiaen.dropshipping.service.IProductService;
import com.messiaen.dropshipping.transformer.entity.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService implements IProductService {

    private final ProductTransformer productTransformer;

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductTransformer productTransformer, ProductRepository productRepository) {
        this.productTransformer = productTransformer;
        this.productRepository = productRepository;
    }

    @Override
    public Collection<ProductDto> findAll() {
        return productTransformer.transformToDto(productRepository.findAll());
    }

}
