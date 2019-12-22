package com.messiaen.dropshipping.transformer.entity;

import com.messiaen.dropshipping.entity.Product;
import com.messiaen.dropshipping.model.ProductDto;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformer extends Transformer<Product, ProductDto, Integer> {

    private final CategoryTransformer categoryTransformer;

    @Autowired
    public ProductTransformer(CategoryTransformer categoryTransformer) {
        this.categoryTransformer = categoryTransformer;
    }

    @Override
    public ProductDto transformToDto(@Nullable Product entity) {
        return entity == null ? null :
                ProductDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .desc(entity.getDesc())
                        .path(entity.getPath())
                        .price(entity.getPrice())
                        .stock(entity.getStock())
                        .categoryId(categoryTransformer.extractKey(entity.getCategory()))
                        .build();
    }

    @Override
    public Integer extractKey(Product entity) {
        return entity == null ? null : entity.getId();
    }

    @Override
    public Product transformToEntity(@Nullable ProductDto dto) {
        return dto == null ? null :
                Product.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .desc(dto.getDesc())
                        .path(dto.getPath())
                        .price(dto.getPrice())
                        .stock(dto.getStock())
                        .category(categoryTransformer.holdKey(dto.getCategoryId()))
                        .build();
    }

    @Override
    public Product holdKey(@Nullable Integer key) {
        return key == null ? null : Product.builder().id(key).build();
    }

}
