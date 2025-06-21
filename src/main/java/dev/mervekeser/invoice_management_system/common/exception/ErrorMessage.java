package dev.mervekeser.invoice_management_system.common.exception;

import dev.mervekeser.invoice_management_system.common.exception.type.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private MessageType messageType;
    private String ofStatic;

    public String prepareErrorMessage(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageType.getMessage());
        if(ofStatic != null){
            stringBuilder.append(" : " + ofStatic);
        }
        return stringBuilder.toString();
    }
}
