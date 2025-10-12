package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.products.application.command.*;
import com.groupe2cs.bizyhub.products.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductDeleteApplicationService {

	private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;

	public void deleteProduct(ProductId idVo, MetaRequest metaRequest) {

		userValidationService.shouldBePremiumUser(metaRequest.getUserId());

		DeleteProductCommand command = new DeleteProductCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
