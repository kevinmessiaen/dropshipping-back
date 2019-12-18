package com.messiaen.dropshipping.repository.wrapper;

import com.messiaen.dropshipping.entity.Basket;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BasketWrapper {
    private Basket basket;
    private Long items;
    private Double price;
}
