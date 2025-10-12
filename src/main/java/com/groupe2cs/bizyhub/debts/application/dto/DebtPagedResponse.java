package com.groupe2cs.bizyhub.debts.application.dto;

import com.groupe2cs.bizyhub.debts.infrastructure.entity.Debt;
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
@Schema(name = "DebtPagedResponse", description = "Paginated response for Debt results")
public class DebtPagedResponse implements Serializable {

	@Schema(description = "List of paginated Debt items")
	private List<DebtResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static DebtPagedResponse from(Page<Debt> page, List<DebtResponse> content) {
		return DebtPagedResponse.builder()
				.content(content)
				.page(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages())
				.build();
	}
}
