package com.messiaen.dropshipping.transformer.calculator;

import com.messiaen.dropshipping.entity.ShippingMethod;
import com.messiaen.dropshipping.model.BasketDto;
import com.messiaen.dropshipping.model.ShippingMethodDto;
import com.messiaen.dropshipping.repository.wrapper.BasketWrapper;
import com.messiaen.dropshipping.utils.WorkingDayUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ShippingCalculator {

    public ShippingMethodDto calculate(ShippingMethod method, BasketDto basket) {
        if (method.getMinimumOrderValue() != null && method.getMinimumOrderValue() > basket.getPrice())
            return null;

        return ShippingMethodDto.builder()
                .id(method.getId())
                .name(method.getName())
                .fees(method.getOfferedOrderValue() > basket.getPrice() ? method.getFees() : 0.0)
                .deliveryDate(WorkingDayUtils.deliveryDate(method.getMinimumWorkingDays(), method.getMaximumWorkingDays()))
                .build();
    }

    public Collection<ShippingMethodDto> available(Collection<ShippingMethod> methods, BasketDto basket) {
       return methods.stream().map(m -> calculate(m, basket)).filter(Objects::nonNull).collect(Collectors.toList());
    }

}
