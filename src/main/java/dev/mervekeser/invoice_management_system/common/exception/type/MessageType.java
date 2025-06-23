package dev.mervekeser.invoice_management_system.common.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageType {
    ADDRESS_ALREADY_EXISTS(3001, "This address already exists"),
    ADDRESS_NOT_FOUND(3002, "This address not found"),
    COMPANY_NOT_FOUND(3003, "This company not found"),
    USER_NOT_FOUND(3004, "This user not found"),
    PRODUCT_NOT_FOUND(3005, "This product not found"),
    INVOICE_NOT_FOUND(3006, "This invoice not found"),
    INVOICE_STATUS_NOT_AVAILABLE(3007, "This invoice cannot update")
    ;

    private final Integer errorCode;
    private final String message;


}
