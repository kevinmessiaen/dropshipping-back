package com.messiaen.dropshipping.transformer.entity;

import com.messiaen.dropshipping.entity.Category;
import com.messiaen.dropshipping.model.CategoryDto;
import com.sun.istack.Nullable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class CategoryTransformer extends Transformer<Category, CategoryDto, Short> {

    @Override
    public CategoryDto transformToDto(@Nullable Category entity) {
        return entity == null ? null :
                CategoryDto.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .desc(entity.getDesc())
                        .path(entity.getPath())
                        .parent(extractKey(entity.getParent()))
                        .children(extractKey(entity.getChildren()))
                        .level(getLevel(entity))
                        .build();
    }

    @Override
    public Short extractKey(Category entity) {
        return entity == null ? null : entity.getId();
    }

    @Override
    public Category transformToEntity(@Nullable CategoryDto dto) {
        return dto == null ? null :
                Category.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .desc(dto.getDesc())
                        .path(dto.getPath())
                        .parent(holdKey(dto.getParent()))
                        .children(holdKey(dto.getChildren()))
                        .build();
    }

    @Override
    public Category holdKey(@Nullable Short key) {
        return key == null ? null : Category.builder().id(key).build();
    }

    @NotNull
    private Integer getLevel(@Nullable Category category) {
        return category == null ? 0 : 1 + getLevel(category.getParent());
    }
}
