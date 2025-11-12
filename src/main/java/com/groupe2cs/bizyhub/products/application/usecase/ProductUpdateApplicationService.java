package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.command.UpdateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductCreatedBy;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductTenant;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;

	public ProductResponse updateProduct(ProductId id, ProductRequest request,
										 MetaRequest metaRequest
	) {

		userValidationService.shouldBePremiumUser(metaRequest.getUserId());

		UpdateProductCommand command = ProductMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(ProductCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(ProductTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return ProductMapper.toResponse(command);
	}

}
