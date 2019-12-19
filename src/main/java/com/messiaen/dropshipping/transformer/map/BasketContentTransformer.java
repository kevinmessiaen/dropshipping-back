package com.messiaen.dropshipping.transformer.map;

import com.messiaen.dropshipping.entity.BasketContent;
import com.messiaen.dropshipping.transformer.entity.ProductTransformer;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class BasketContentTransformer extends MapTransformer<BasketContent, Integer, Short> {

    private final ProductTransformer productTransformer;

    public BasketContentTransformer(ProductTransformer productTransformer) {
        this.productTransformer = productTransformer;
    }

    @Override
    public Integer extractKey(BasketContent entity) {
        return entity == null ? null : productTransformer.extractKey(entity.getId().getProduct());
    }

    @Override
    public Short extractValue(BasketContent entity) {
        return entity == null ? null : entity.getAmount();
    }

    @Override
    public BasketContent transformToEntity(@NotNull Integer key, @NotNull Short value) {
        return BasketContent.builder()
                .id(BasketContent.BasketContentId.builder().product(productTransformer.holdKey(key)).build())
                .amount(value)
                .build();
    }


}
