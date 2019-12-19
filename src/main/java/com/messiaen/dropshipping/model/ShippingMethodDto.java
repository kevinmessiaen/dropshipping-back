package com.messiaen.dropshipping.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShippingMethodDto {

    private Short id;
    private String name;
    private String deliveryDate;
    private Double fees;

}
