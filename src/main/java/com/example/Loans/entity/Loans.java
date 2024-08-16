package com.example.Loans.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Loans extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    @Column(nullable = false)
    private String mobileNumber;

    @Column(nullable = false)
    private String loanNumber;

    @Column(nullable = false)
    private String loanType;

    @Column(nullable = false)
    private Long totalLoan;

    @Column(nullable = false)
    private int amountPaid;

    @Column(nullable = false)
    private int outstandingAmount;

}
