package com.groupe2cs.bizyhub.sync.application.dto;

import com.groupe2cs.bizyhub.sync.infrastructure.entity.ChangeLog;
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
@Schema(name = "ChangeLogPagedResponse", description = "Paginated response for ChangeLog results")
public class ChangeLogPagedResponse implements Serializable {

	@Schema(description = "List of paginated ChangeLog items")
	private List<ChangeLogResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static ChangeLogPagedResponse from(Page<ChangeLog> page, List<ChangeLogResponse> content) {
		return ChangeLogPagedResponse.builder()
				.content(content)
				.page(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages())
				.build();
	}
}
