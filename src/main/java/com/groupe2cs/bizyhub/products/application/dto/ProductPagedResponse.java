package com.groupe2cs.bizyhub.products.application.dto;

import com.groupe2cs.bizyhub.products.infrastructure.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ProductPagedResponse", description = "Paginated response for Product results")
public class ProductPagedResponse implements Serializable {

    @Schema(description = "List of paginated Product items")
    private List<ProductResponse> content;

    @Schema(description = "Current page number", example = "0")
    private int page;

    @Schema(description = "Page size", example = "10")
    private int size;

    @Schema(description = "Total number of elements", example = "100")
    private long totalElements;

    @Schema(description = "Total number of pages", example = "10")
    private long totalPages;

    public static ProductPagedResponse from(Page<Product> page, List<ProductResponse> content) {
        return ProductPagedResponse.builder()
                .content(content)
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }
}
