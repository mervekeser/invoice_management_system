package dev.mervekeser.invoice_management_system.domain.entities.enums;

public enum InvoiceStatus {
    DRAFT("Draft"),
    SENT("Sent"),
    PAID("Paid"),
    DELAYED("Delayed");

    private final String status;
    InvoiceStatus(String status){
        this.status = status;
    }

    public String getInvoiceMethod(){
        return status;
    }
}
