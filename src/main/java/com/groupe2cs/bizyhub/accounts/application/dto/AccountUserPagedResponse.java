package com.groupe2cs.bizyhub.accounts.application.dto;

import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUser;
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
@Schema(name = "AccountUserPagedResponse", description = "Paginated response for AccountUser results")
public class AccountUserPagedResponse implements Serializable {

	@Schema(description = "List of paginated AccountUser items")
	private List<AccountUserResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static AccountUserPagedResponse from(Page<AccountUser> page, List<AccountUserResponse> content) {
		return AccountUserPagedResponse.builder()
				.content(content)
				.page(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages())
				.build();
	}
}
