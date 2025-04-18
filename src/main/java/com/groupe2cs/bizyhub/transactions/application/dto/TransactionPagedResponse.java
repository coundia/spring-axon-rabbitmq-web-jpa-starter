package com.groupe2cs.bizyhub.transactions.application.dto;

import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
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
@Schema(name = "TransactionPagedResponse", description = "Paginated response for Transaction results")
public class TransactionPagedResponse implements Serializable {

    @Schema(description = "List of paginated Transaction items")
    private List<TransactionResponse> content;

    @Schema(description = "Current page number", example = "0")
    private int page;

    @Schema(description = "Page size", example = "10")
    private int size;

    @Schema(description = "Total number of elements", example = "100")
    private long totalElements;

    @Schema(description = "Total number of pages", example = "10")
    private long totalPages;

    public static TransactionPagedResponse from(Page<Transaction> page, List<TransactionResponse> content) {
        return TransactionPagedResponse.builder()
                .content(content)
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }
}
