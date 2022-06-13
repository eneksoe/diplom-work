package com.bta.diplom.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @Size(max = 100)
    @NotBlank
    private String name;

    @Column(name = "sku_code")
    @NotNull
    private Integer skuCode;

    @Column(name = "unit_price")
    @NotNull
    @Min(value = 0)
    private Integer unitPrice;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<OrderLine> orderLines;
}
