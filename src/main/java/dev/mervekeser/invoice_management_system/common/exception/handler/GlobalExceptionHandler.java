package dev.mervekeser.invoice_management_system.common.exception.handler;

import dev.mervekeser.invoice_management_system.common.exception.AlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    private List<String> addMapValue(List<String> list, String newValue){
        list.add(newValue);
        return list;
    }

    @ExceptionHandler(value = AlreadyExistsException.class)
    public ResponseEntity<ApiError> handleAlreadyExistsException(AlreadyExistsException alreadyExistsException, WebRequest webRequest){
        return ResponseEntity.badRequest().body(createApiError(alreadyExistsException.getMessage(), webRequest));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest webRequest){
        Map<String, List<String>> errorsMap = new HashMap<>();
        for(ObjectError objectError : exception.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError)objectError).getField();
            if(errorsMap.containsKey(fieldName)){
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objectError.getDefaultMessage()));
            }else{
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
            }
        }

        return ResponseEntity.badRequest().body(createApiError(errorsMap, webRequest));
    }



    //generic function
    private <T> ApiError<T> createApiError(T errors, WebRequest webRequest){
        ApiError<T> apiError = new ApiError<>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<T> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setHostName(getHostName());
        exception.setPath(webRequest.getDescription(false).substring(4));
        exception.setMessage(errors);

        apiError.setException(exception);

        return apiError;
    }

    private String getHostName(){
        try {
            return InetAddress.getLocalHost().getHostName();
        }catch (UnknownHostException e){
            System.out.println("An error occured " + e.getMessage());
        }
        return null;
    }
}
