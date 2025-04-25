package com.groupe2cs.bizyhub.security.application.dto;

import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
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
@Schema(name = "RolePermissionPagedResponse", description = "Paginated response for RolePermission results")
public class RolePermissionPagedResponse implements Serializable {

@Schema(description = "List of paginated RolePermission items")
private List<RolePermissionResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static RolePermissionPagedResponse from(Page<RolePermission> page, List<RolePermissionResponse> content) {
		return RolePermissionPagedResponse.builder()
		.content(content)
		.page(page.getNumber())
		.size(page.getSize())
		.totalElements(page.getTotalElements())
		.totalPages(page.getTotalPages())
		.build();
		}
}
