package com.bta.diplom.model;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "order_line")
public class OrderLine extends AbstractBaseEntity{

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;
}
