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
@Schema(name = "RefreshTokenPagedResponse", description = "Paginated response for RefreshToken results")
public class RefreshTokenPagedResponse implements Serializable {

	@Schema(description = "List of paginated RefreshToken items")
	private List<RefreshTokenResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static RefreshTokenPagedResponse from(Page<RefreshToken> page, List<RefreshTokenResponse> content) {
		return RefreshTokenPagedResponse.builder()
				.content(content)
				.page(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages())
				.build();
	}
}
