package com.messiaen.dropshipping.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BasketContent {

    @EmbeddedId
    private BasketContentId id;

    @Column
    private Short amount;

    @Embeddable
    public static class BasketContentId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "basket_id")
        private Basket basket;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;

    }

}
