package com.example.Loans.mapper;


import com.example.Loans.dto.LoansDto;
import com.example.Loans.entity.Loans;

public class LoanMapper {
    public static Loans mapToLoan(LoansDto loansDto)
    {
        Loans loan=Loans.builder()
                .mobileNumber(loansDto.getMobileNumber())
                .loanNumber(loansDto.getLoanType())
                .loanType(loansDto.getLoanType())
                .amountPaid(loansDto.getAmountPaid())
                .outstandingAmount(loansDto.getOutstandingAmount())
                .build();
        return loan;
    }

    public static  LoansDto mapToLoanDto(Loans loan)
    {
        return LoansDto.builder()
                .mobileNumber(loan.getMobileNumber())
                .loanType(loan.getLoanType())
                .totalLoan(loan.getTotalLoan())
                .amountPaid(loan.getAmountPaid())
                .loanNumber(loan.getLoanNumber())
                .outstandingAmount(loan.getOutstandingAmount())
                .build();
    }
}
