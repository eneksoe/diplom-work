package com.bta.diplom.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "sku_code")
    @Size(max = 100)
    private Integer skuCode;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @ToString.Exclude
    @OneToMany(fetch =  FetchType.EAGER, mappedBy = "product")
    private List<OrderLine> orderLines;
}
