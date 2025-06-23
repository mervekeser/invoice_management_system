package dev.mervekeser.invoice_management_system.common.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvoiceStatusException extends RuntimeException {
    public InvoiceStatusException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}
