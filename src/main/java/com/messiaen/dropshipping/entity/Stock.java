package com.messiaen.dropshipping.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Stock {

    @Id
    @Column(name = "product_id")
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer quantity;

    @Column(name = "in_basket")
    private Integer inBasket;

    @Version
    private Integer version;

}
