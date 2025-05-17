package com.groupe2cs.bizyhub.categories.application.usecase;

import com.groupe2cs.bizyhub.categories.application.command.CreateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.application.mapper.CategoryMapper;
import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryCreatedBy;
import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCreateApplicationService {
	private final CommandGateway commandGateway;

	public CategoryResponse createCategory(CategoryRequest request,
										   MetaRequest metaRequest
	) {

		CreateCategoryCommand command = CategoryMapper.toCommand(
				request
		);

		command.setCreatedBy(CategoryCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(CategoryTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return CategoryMapper.toResponse(command);
	}


}
