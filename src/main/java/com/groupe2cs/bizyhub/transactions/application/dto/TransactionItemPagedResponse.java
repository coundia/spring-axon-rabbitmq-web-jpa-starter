package com.groupe2cs.bizyhub.transactions.application.dto;

import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItem;
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
@Schema(name = "TransactionItemPagedResponse", description = "Paginated response for TransactionItem results")
public class TransactionItemPagedResponse implements Serializable {

	@Schema(description = "List of paginated TransactionItem items")
	private List<TransactionItemResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static TransactionItemPagedResponse from(Page<TransactionItem> page, List<TransactionItemResponse> content) {
		return TransactionItemPagedResponse.builder()
				.content(content)
				.page(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages())
				.build();
	}
}
