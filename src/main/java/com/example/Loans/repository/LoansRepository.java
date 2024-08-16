package com.example.Loans.repository;

import com.example.Loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository  extends JpaRepository<Loans,Integer> {

    public Optional<Loans> findByMobileNumber(String mobileNumber);

    public Optional<Loans> findByLoanNumber(String loanNumber);
}
