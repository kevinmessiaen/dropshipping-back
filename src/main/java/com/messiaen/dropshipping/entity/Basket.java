package com.messiaen.dropshipping.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "basket")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Basket {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToMany(mappedBy = "id.basket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<BasketContent> content;

}
