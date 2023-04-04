package com.czechowiczk.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(name = "fraud_history_seq_gen",
            sequenceName = "fraud_history_seq_gen")
    @GeneratedValue(generator = "fraud_history_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
