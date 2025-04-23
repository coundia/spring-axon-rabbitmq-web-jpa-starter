package com.groupe2cs.bizyhub.security.application.dto;

import com.groupe2cs.bizyhub.security.infrastructure.entity.UserRole;
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
@Schema(name = "UserRolePagedResponse", description = "Paginated response for UserRole results")
public class UserRolePagedResponse implements Serializable {

	@Schema(description = "List of paginated UserRole items")
	private List<UserRoleResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static UserRolePagedResponse from(Page<UserRole> page, List<UserRoleResponse> content) {
		return UserRolePagedResponse.builder()
				.content(content)
				.page(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages())
				.build();
	}
}
