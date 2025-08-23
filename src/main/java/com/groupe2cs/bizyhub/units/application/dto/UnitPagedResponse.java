package com.groupe2cs.bizyhub.units.application.dto;

import com.groupe2cs.bizyhub.units.infrastructure.entity.*;
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
@Schema(name = "UnitPagedResponse", description = "Paginated response for Unit results")
public class UnitPagedResponse implements Serializable {

@Schema(description = "List of paginated Unit items")
private List<UnitResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static UnitPagedResponse from(Page<Unit> page, List<UnitResponse> content) {
		return UnitPagedResponse.builder()
		.content(content)
		.page(page.getNumber())
		.size(page.getSize())
		.totalElements(page.getTotalElements())
		.totalPages(page.getTotalPages())
		.build();
		}
}
