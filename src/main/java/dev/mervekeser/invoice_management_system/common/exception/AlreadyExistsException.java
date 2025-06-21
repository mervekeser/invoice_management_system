package dev.mervekeser.invoice_management_system.common.exception;

import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(ErrorMessage errorMessage){
        super(errorMessage.prepareErrorMessage());
    }


}
