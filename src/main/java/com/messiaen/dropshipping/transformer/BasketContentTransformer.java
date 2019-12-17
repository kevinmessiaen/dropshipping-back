package com.messiaen.dropshipping.transformer;

import com.messiaen.dropshipping.entity.Basket;
import com.messiaen.dropshipping.entity.BasketContent;
import com.messiaen.dropshipping.model.BasketDto;
import com.sun.istack.Nullable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

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
