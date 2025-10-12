package com.groupe2cs.bizyhub.customers.application.dto;

import com.groupe2cs.bizyhub.customers.infrastructure.entity.Customer;
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
@Schema(name = "CustomerPagedResponse", description = "Paginated response for Customer results")
public class CustomerPagedResponse implements Serializable {

	@Schema(description = "List of paginated Customer items")
	private List<CustomerResponse> content;

	@Schema(description = "Current page number", example = "0")
	private int page;

	@Schema(description = "Page size", example = "10")
	private int size;

	@Schema(description = "Total number of elements", example = "100")
	private long totalElements;

	@Schema(description = "Total number of pages", example = "10")
	private long totalPages;

	public static CustomerPagedResponse from(Page<Customer> page, List<CustomerResponse> content) {
		return CustomerPagedResponse.builder()
				.content(content)
				.page(page.getNumber())
				.size(page.getSize())
				.totalElements(page.getTotalElements())
				.totalPages(page.getTotalPages())
				.build();
	}
}
