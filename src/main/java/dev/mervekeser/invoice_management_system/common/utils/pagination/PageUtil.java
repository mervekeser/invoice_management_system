package dev.mervekeser.invoice_management_system.common.utils.pagination;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@UtilityClass
public class PageUtil {
    public boolean isNullOrEmpty(String value){
        return value == null || value.trim().length() == 0;
    }

    public Pageable toPageable(PageableRequest pageableRequest){
        if(!isNullOrEmpty(pageableRequest.getColumnName())){
            Sort sortBy = pageableRequest.isAsc() ? Sort.by(Sort.Direction.ASC, pageableRequest.getColumnName())
                    : Sort.by(Sort.Direction.DESC, pageableRequest.getColumnName());

            return PageRequest.of(pageableRequest.getPageNumber(), pageableRequest.getPageSize(), sortBy);
        }

        return PageRequest.of(pageableRequest.getPageNumber(), pageableRequest.getPageSize());
    }

    public <T> PageableEntity<T> toPageableResponse(Page<?> page, List<T> content){
        PageableEntity<T> pageableEntity = new PageableEntity<>();
        pageableEntity.setContent(content);
        pageableEntity.setPageNumber(page.getPageable().getPageNumber());
        pageableEntity.setPageSize(page.getPageable().getPageSize());
        pageableEntity.setTotalElements(page.getTotalElements());

        return pageableEntity;
    }
}
