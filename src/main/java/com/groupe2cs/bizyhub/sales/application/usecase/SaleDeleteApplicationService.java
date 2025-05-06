package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteSale(SaleId idVo, MetaRequest metaRequest) {

DeleteSaleCommand command = new DeleteSaleCommand(idVo);
commandGateway.sendAndWait(command);
}
}
