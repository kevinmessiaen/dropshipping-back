package com.messiaen.dropshipping.transformer;

import com.messiaen.dropshipping.entity.BasketContent;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class BasketContentTransformer extends MapTransformer<BasketContent, Integer, Short> {

    @Override
    public Integer extractKey(BasketContent entity) {
        return null;
    }

    @Override
    public Short extractValue(BasketContent entity) {
        return null;
    }

    @Override
    public BasketContent transformToEntity(@NotNull Integer key, @NotNull Short value) {
        return null;
    }
}
