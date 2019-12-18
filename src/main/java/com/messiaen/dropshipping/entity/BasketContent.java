package com.messiaen.dropshipping.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "basket_content")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasketContent {

    @EmbeddedId
    private BasketContentId id;

    @Column
    private Short amount;

    @Embeddable
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class BasketContentId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "basket_id")
        private Basket basket;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "product_id")
        private Product product;

    }

}
