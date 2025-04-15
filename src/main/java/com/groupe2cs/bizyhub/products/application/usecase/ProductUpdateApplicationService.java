package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.command.UpdateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateApplicationService {

    private final FileStorageService fileStorageService;
    private final CommandGateway commandGateway;


    public ProductResponse updateProduct(ProductId id, ProductRequest request) {

        UpdateProductCommand command = ProductMapper.toUpdateCommand(
                id,
                request
        );

        commandGateway.sendAndWait(command);

        return ProductMapper.toResponse(command);
    }

}
