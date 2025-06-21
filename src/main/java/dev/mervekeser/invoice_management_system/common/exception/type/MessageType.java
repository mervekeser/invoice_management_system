package dev.mervekeser.invoice_management_system.common.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageType {
    ADDRESS_ALREADY_EXISTS(3001, "This address already exists");

    private final Integer errorCode;
    private final String message;


}
