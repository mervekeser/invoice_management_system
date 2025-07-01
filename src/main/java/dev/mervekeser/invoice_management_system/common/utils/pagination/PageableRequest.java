package dev.mervekeser.invoice_management_system.common.utils.pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableRequest {
    private int pageNumber;
    private int pageSize;
    private String columnName;
    private boolean isAsc;
}
