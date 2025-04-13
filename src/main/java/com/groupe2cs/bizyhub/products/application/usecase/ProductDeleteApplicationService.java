package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.command.DeleteProductCommand;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteApplicationService {

    private final CommandGateway commandGateway;

    public void deleteProduct(ProductId idVo) {

        DeleteProductCommand command = new DeleteProductCommand(idVo);
        commandGateway.sendAndWait(command);
    }
}
