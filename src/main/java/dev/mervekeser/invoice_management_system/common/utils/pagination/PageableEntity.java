package dev.mervekeser.invoice_management_system.common.utils.pagination;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageableEntity<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
}
