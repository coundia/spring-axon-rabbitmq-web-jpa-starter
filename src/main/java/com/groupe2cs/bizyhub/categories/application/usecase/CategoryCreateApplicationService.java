package com.groupe2cs.bizyhub.categories.application.usecase;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.categories.application.mapper.*;
import com.groupe2cs.bizyhub.categories.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryCreateApplicationService {
private final CommandGateway commandGateway;

public CategoryResponse createCategory(CategoryRequest request,
MetaRequest metaRequest
){

CreateCategoryCommand command = CategoryMapper.toCommand(
request
);

command.setCreatedBy(CategoryCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(CategoryTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return CategoryMapper.toResponse(command);
}


}
