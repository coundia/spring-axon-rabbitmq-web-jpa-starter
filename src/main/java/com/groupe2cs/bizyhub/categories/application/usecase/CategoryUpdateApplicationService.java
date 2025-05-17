package com.groupe2cs.bizyhub.categories.application.usecase;

import com.groupe2cs.bizyhub.categories.application.command.UpdateCategoryCommand;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryRequest;
import com.groupe2cs.bizyhub.categories.application.dto.CategoryResponse;
import com.groupe2cs.bizyhub.categories.application.mapper.CategoryMapper;
import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public CategoryResponse updateCategory(CategoryId id, CategoryRequest request,
										   MetaRequest metaRequest
	) {

		UpdateCategoryCommand command = CategoryMapper.toUpdateCommand(
				id,
				request
		);

		if (metaRequest.getTenantId() != null) {
			//command.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
		}

		commandGateway.sendAndWait(command);

		return CategoryMapper.toResponse(command);
	}

}
