package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCreateApplicationService {
private final CommandGateway commandGateway;

public ProductResponse createProduct(ProductRequest request,
MetaRequest metaRequest
){

CreateProductCommand command = ProductMapper.toCommand(
request
);

command.setCreatedBy(ProductCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(ProductTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return ProductMapper.toResponse(command);
}


}
