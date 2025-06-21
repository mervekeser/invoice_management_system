package dev.mervekeser.invoice_management_system.common.exception.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exception<E> {
    private String hostName;
    private String path;
    private Date createTime;
    private E message;
}
