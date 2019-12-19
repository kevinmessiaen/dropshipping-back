package com.messiaen.dropshipping.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name ="product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column(nullable = false, unique = true, length = 64)
    private String name;

    @Column
    private String desc;

    @Column(nullable = false, unique = true, length = 64)
    private String path;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "id.product")
    private Collection<BasketContent> baskets;

    @OneToMany(mappedBy = "id.product")
    private Collection<OrderContent> orders;

}
