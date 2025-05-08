package com.groupe2cs.bizyhub.products.application.usecase;

import com.groupe2cs.bizyhub.products.application.query.*;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.products.application.mapper.*;
import com.groupe2cs.bizyhub.products.application.dto.*;
import com.groupe2cs.bizyhub.products.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteProduct(ProductId idVo, MetaRequest metaRequest) {

DeleteProductCommand command = new DeleteProductCommand(idVo);
commandGateway.sendAndWait(command);
}
}
