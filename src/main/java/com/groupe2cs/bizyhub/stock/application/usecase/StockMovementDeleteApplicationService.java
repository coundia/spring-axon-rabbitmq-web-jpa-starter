package com.groupe2cs.bizyhub.stock.application.usecase;

import com.groupe2cs.bizyhub.stock.application.command.*;
import com.groupe2cs.bizyhub.stock.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.application.mapper.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockMovementDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteStockMovement(StockMovementId idVo, MetaRequest metaRequest) {

DeleteStockMovementCommand command = new DeleteStockMovementCommand(idVo);
commandGateway.sendAndWait(command);
}
}
