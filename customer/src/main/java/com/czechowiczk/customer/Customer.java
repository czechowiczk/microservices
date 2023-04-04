package com.czechowiczk.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_generator",
            sequenceName = "customer_id_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_id_generator")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
