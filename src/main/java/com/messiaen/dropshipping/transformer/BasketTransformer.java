package com.messiaen.dropshipping.transformer;

import com.messiaen.dropshipping.entity.Basket;
import com.messiaen.dropshipping.model.BasketDto;
import com.messiaen.dropshipping.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BasketTransformer extends Transformer<Basket, BasketDto, UUID> {

    private final BasketContentTransformer basketContentTransformer;

    @Autowired
    public BasketTransformer(BasketContentTransformer basketContentTransformer) {
        this.basketContentTransformer = basketContentTransformer;
    }

    @Override
    public BasketDto transformToDto(Basket entity) {
        return entity == null ? null :
                BasketDto.builder()
                        .id(extractKeyToString(entity))
                        .products(basketContentTransformer.transformToMap(entity.getContent()))
                        .build();
    }

    public String extractKeyToString(Basket entity) {
        UUID key = extractKey(entity);
        return key == null ? null : key.toString();
    }

    @Override
    public UUID extractKey(Basket entity) {
        return entity == null ? null : entity.getId();
    }

    @Override
    public Basket transformToEntity(BasketDto dto) {
        return dto == null ? null :
                Basket.builder()
                        .id(parseKey(dto.getId()))
                        .content(basketContentTransformer.transformToEntity(dto.getProducts()))
                        .build();
    }

    public UUID parseKey(String key) {
        return key == null ? null : UUID.fromString(key);
    }

    @Override
    public Basket holdKey(UUID key) {
        return key == null ? null : Basket.builder().id(key).build();
    }

    public void fuseProducts(Basket dst, BasketDto src) {
        if (dst == null || src == null || src.getProducts() == null || src.getProducts().isEmpty())
            return;

        if (dst.getContent() == null || dst.getContent().isEmpty())
            dst.setContent(basketContentTransformer.transformToEntity(src.getProducts()));
        else
            dst.setContent(basketContentTransformer.transformToEntity(
                    MapUtils.<Integer>countShortValues(basketContentTransformer.transformToMap(dst.getContent()), src.getProducts())));
    }
}
