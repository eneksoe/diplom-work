package com.bta.diplom.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "customer_order")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number")
    @Size(max = 20)
    private String orderNumber;

    @ToString.Exclude
    @ManyToOne(cascade = ALL, fetch = EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "submission_date")
    private ZonedDateTime submissionDate;
}
