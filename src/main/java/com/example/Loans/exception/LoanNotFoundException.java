package com.example.Loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LoanNotFoundException  extends  RuntimeException{
    public LoanNotFoundException(String resourceName,String fieldName,String fieldValue)
    {
        super(resourceName+" not found with the given input data "+fieldName+":"+fieldValue);
    }
}
