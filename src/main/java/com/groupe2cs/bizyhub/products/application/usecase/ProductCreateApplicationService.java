package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.command.CreateProductCommand;
import com.groupe2cs.bizyhub.products.application.dto.ProductRequest;
import com.groupe2cs.bizyhub.products.application.dto.ProductResponse;
import com.groupe2cs.bizyhub.products.application.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCreateApplicationService {
    private final CommandGateway commandGateway;

    public ProductResponse createProduct(ProductRequest request) {

        CreateProductCommand command = ProductMapper.toCommand(request);
        commandGateway.sendAndWait(command);
        return ProductMapper.toResponse(command);
    }
}
