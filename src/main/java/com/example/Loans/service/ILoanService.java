package com.example.Loans.service;

import com.example.Loans.dto.LoansDto;
import com.example.Loans.entity.Loans;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ILoanService {

    public void createLoan(String mobileNumber);

    public Loans fetchLoans(String mobileNumber);

    public boolean updateLoans(LoansDto loansDto);

    public boolean deleteLoans(String loansNumber);
}
