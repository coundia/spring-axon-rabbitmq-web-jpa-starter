package com.groupe2cs.bizyhub.categories.application.usecase;

import com.groupe2cs.bizyhub.categories.application.command.DeleteCategoryCommand;
import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteCategory(CategoryId idVo, MetaRequest metaRequest) {

		DeleteCategoryCommand command = new DeleteCategoryCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
