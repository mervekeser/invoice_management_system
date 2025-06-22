package dev.mervekeser.invoice_management_system.domain.entities.enums;

public enum PaymentMethod {
    CASH("Cash"),
    CREDIT_CARD("Credit Card"),
    TRANSFER("Transfer");

    private final String method;
    PaymentMethod(String method){
        this.method = method;
    }

    public String getPaymentMethod(){
        return method;
    }
}
