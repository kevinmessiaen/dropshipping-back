package com.messiaen.dropshipping.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_content")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderContent {

    @EmbeddedId
    private OrderContentId id;

    @Column
    private Short amount;

    @Column
    private Double price;

    @Embeddable
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class OrderContentId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "order_id")
        private Order order;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id")
        private Product product;

    }

}
