package com.techgig.CopilotHackathon.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    private String status;
    public ProductException(String message,String status) {
        super(message);
        this.status=status;
    }
}
