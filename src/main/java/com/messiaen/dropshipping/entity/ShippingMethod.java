package com.messiaen.dropshipping.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "shipping_method")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShippingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Short id;

    @Column(length = 16, unique = true, nullable = false)
    private String name;

    @Column(name = "min_work_days", nullable = false)
    private Integer minimumWorkingDays;

    @Column(name = "max_work_days")
    private Integer maximumWorkingDays;

    @Column(nullable = false)
    private Double fees;

    @Column(name = "min_order")
    private Double minimumOrderValue;

    @Column(name = "free_min_order")
    private Double offeredOrderValue;

}
