package com.groupe2cs.bizyhub.security.application.dto;

import com.groupe2cs.bizyhub.security.infrastructure.entity.Role;
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
@Schema(name = "RolePagedResponse", description = "Paginated response for Role results")
public class RolePagedResponse implements Serializable {

	@Schema(description = "List of paginated Role items")
	private List<RoleResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static RolePagedResponse from(Page<Role> page, List<RoleResponse> content) {
		return RolePagedResponse.builder()
				.content(content)
				.page(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages())
				.build();
	}
}
