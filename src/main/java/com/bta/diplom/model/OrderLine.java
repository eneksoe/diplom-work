package com.bta.diplom.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "order_line")
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;
}
