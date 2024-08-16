package com.example.Loans.service;

import com.example.Loans.dto.LoansDto;
import com.example.Loans.entity.Loans;
import com.example.Loans.exception.LoanAlreadyExistException;
import com.example.Loans.exception.LoanNotFoundException;
import com.example.Loans.repository.LoansRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoanServiceImpl implements ILoanService {

    private final LoansRepository loansRepository;

    public LoanServiceImpl(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @Override
    public void createLoan(String mobileNumber) {
         Optional<Loans> loan=loansRepository.findByMobileNumber(mobileNumber);
         if(loan.isPresent())
         {
             throw new LoanAlreadyExistException("Loan Already exist with given mobile number:"+mobileNumber);
         }
        loansRepository.save(createLoanData(mobileNumber));
    }

    @Override
    public Loans fetchLoans(String mobileNumber) {
        Loans loan=loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new LoanNotFoundException("Loan","mobile Number: ",mobileNumber.toString())
        );
        return loan;
    }

    @Override
    public boolean updateLoans(LoansDto loansDto) {
        Loans loan=loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                ()->new LoanNotFoundException("Loan","Loan Number: ",loansDto.getMobileNumber())
        );
        loan.setLoanType(loansDto.getLoanType());
        loan.setTotalLoan(loansDto.getTotalLoan());
        loan.setAmountPaid(loansDto.getAmountPaid());
        loan.setMobileNumber(loansDto.getMobileNumber());
        loan.setOutstandingAmount(loansDto.getOutstandingAmount());

        loansRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteLoans(String loansNumber) {
        Loans loan=loansRepository.findByLoanNumber(loansNumber).orElseThrow(
                ()->new LoanNotFoundException("Loan","Loan Number: ",loansNumber)
        );
        loansRepository.delete(loan);
        return false;
    }

    private Loans  createLoanData(String mobileNumber)
    {
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        Loans loan=Loans.builder()
                .mobileNumber(mobileNumber)
                .loanNumber(Long.toString(randomLoanNumber))
                .loanType("Home_Loan")
                .totalLoan(1000000000000L)
                .amountPaid(0)
                .outstandingAmount(10000000)
                .build();
        return loan;
    }
}
