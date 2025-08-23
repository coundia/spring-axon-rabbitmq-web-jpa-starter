package com.groupe2cs.bizyhub.stock.application.dto;

import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "StockMovementPagedResponse", description = "Paginated response for StockMovement results")
public class StockMovementPagedResponse implements Serializable {

@Schema(description = "List of paginated StockMovement items")
private List<StockMovementResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static StockMovementPagedResponse from(Page<StockMovement> page, List<StockMovementResponse> content) {
		return StockMovementPagedResponse.builder()
		.content(content)
		.page(page.getNumber())
		.size(page.getSize())
		.totalElements(page.getTotalElements())
		.totalPages(page.getTotalPages())
		.build();
		}
}
