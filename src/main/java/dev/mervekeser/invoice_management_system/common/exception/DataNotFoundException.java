package dev.mervekeser.invoice_management_system.common.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(ErrorMessage errorMessage){
        super(errorMessage.prepareErrorMessage());
    }
}
