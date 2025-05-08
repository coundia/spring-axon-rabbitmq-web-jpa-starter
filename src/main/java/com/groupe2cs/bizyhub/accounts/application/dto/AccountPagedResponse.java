package com.groupe2cs.bizyhub.accounts.application.dto;

import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
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
@Schema(name = "AccountPagedResponse", description = "Paginated response for Account results")
public class AccountPagedResponse implements Serializable {

@Schema(description = "List of paginated Account items")
private List<AccountResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static AccountPagedResponse from(Page<Account> page, List<AccountResponse> content) {
		return AccountPagedResponse.builder()
		.content(content)
		.page(page.getNumber())
		.size(page.getSize())
		.totalElements(page.getTotalElements())
		.totalPages(page.getTotalPages())
		.build();
		}
}
