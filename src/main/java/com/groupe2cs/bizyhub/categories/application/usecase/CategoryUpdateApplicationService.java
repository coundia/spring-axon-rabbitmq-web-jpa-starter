package com.groupe2cs.bizyhub.categories.application.usecase;

import com.groupe2cs.bizyhub.categories.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.categories.application.command.*;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.categories.application.query.*;
import com.groupe2cs.bizyhub.categories.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public CategoryResponse updateCategory(CategoryId id,CategoryRequest request,
MetaRequest metaRequest
){

UpdateCategoryCommand command = CategoryMapper.toUpdateCommand(
id,
request
);

if(metaRequest.getTenantId() != null) {
	//command.setTenant(CategoryTenant.create(metaRequest.getTenantId()));
}

commandGateway.sendAndWait(command);

return CategoryMapper.toResponse(command);
}

}
