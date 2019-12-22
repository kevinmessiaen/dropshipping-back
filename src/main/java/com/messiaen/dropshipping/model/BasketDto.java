package com.messiaen.dropshipping.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Min;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BasketDto {

    private String id;

    private Map<Integer, @Min(value = 0, message = "Le nombre de produits ne peut être négatif") Short> products;

    private Long items;

    private Double price;

}
