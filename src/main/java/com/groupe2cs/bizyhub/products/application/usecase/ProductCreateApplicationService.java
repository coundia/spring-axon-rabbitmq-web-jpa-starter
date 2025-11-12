package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductCreatedBy;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductTenant;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCreateApplicationService {
	private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;


	public ProductResponse createProduct(ProductRequest request,
										 MetaRequest metaRequest
	) {

		userValidationService.shouldBePremiumUser(metaRequest.getUserId());

		CreateProductCommand command = ProductMapper.toCommand(
				request
		);

		command.setCreatedBy(ProductCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(ProductTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return ProductMapper.toResponse(command);
	}


}
