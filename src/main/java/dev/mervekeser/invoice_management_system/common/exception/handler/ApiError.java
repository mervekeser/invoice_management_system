package dev.mervekeser.invoice_management_system.common.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError<E> {
    private String id;
    private Integer status;
    Exception<E> exception;
}
