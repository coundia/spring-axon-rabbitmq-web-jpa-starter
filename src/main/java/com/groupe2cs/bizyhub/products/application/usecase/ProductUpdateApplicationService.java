package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.products.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.products.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public ProductResponse updateProduct(ProductId id,ProductRequest request){

UpdateProductCommand command = ProductMapper.toUpdateCommand(
id,
request
);

commandGateway.sendAndWait(command);

return ProductMapper.toResponse(command);
}

}
