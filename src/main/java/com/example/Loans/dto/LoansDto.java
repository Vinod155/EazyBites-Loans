package com.example.Loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name="Loan",
        description = "Schema to hold Loan details"
)
public class LoansDto {
    @Schema(
            description = "Mobile Number of the Customer",name="1234567891"
    )
    @NotEmpty(message = "Mobile Number Cannot be null or empty")
    @Pattern(regexp = "$|[0-9]{10}" , message = "Mobile must be 10 digits")
    private String mobileNumber;


    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    @Schema(
            description = "Loan Number of the customer", example = "548732457654"
    )
    private String loanNumber;
    @NotEmpty(message = "LoanType can not be a null or empty")
    @Schema(
            description = "Type of the loan", example = "Home Loan"
    )
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount", example = "100000"
    )
    private Long totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private int outstandingAmount;
}
