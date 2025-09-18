package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.UserValidationService;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.products.application.command.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;
	private final UserValidationService userValidationService;

public ProductResponse updateProduct(ProductId id,ProductRequest request,
MetaRequest metaRequest
){

	userValidationService.shouldBePremiumUser(metaRequest.getUserId()) ;

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
