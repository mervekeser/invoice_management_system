package dev.mervekeser.invoice_management_system.common.utils.rest;

import dev.mervekeser.invoice_management_system.common.exception.handler.ApiError;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestRootEntity<T> {
    private Integer status;
    private T payload;
    private ApiError errorMessage;

    public static <T> RestRootEntity<T> ok(T payload){
        RestRootEntity<T> rootEntity = new RestRootEntity<>();
        rootEntity.setStatus(HttpStatus.OK.value());
        rootEntity.setErrorMessage(null);
        rootEntity.setPayload(payload);

        return rootEntity;
    }

    public static <T> RestRootEntity<T> created(T payload){
        RestRootEntity<T> rootEntity = new RestRootEntity<>();
        rootEntity.setStatus(HttpStatus.CREATED.value());
        rootEntity.setErrorMessage(null);
        rootEntity.setPayload(payload);

        return rootEntity;
    }
}
