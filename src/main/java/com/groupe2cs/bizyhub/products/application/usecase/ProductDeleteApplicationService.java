package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.command.DeleteProductCommand;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteProduct(ProductId idVo, MetaRequest metaRequest) {

		DeleteProductCommand command = new DeleteProductCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
