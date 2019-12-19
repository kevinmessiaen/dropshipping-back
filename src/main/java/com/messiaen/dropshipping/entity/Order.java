package com.messiaen.dropshipping.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Short id;

    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<OrderContent> content;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
