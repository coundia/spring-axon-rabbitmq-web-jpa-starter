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
public class StockLevelDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteStockLevel(StockLevelId idVo, MetaRequest metaRequest) {

DeleteStockLevelCommand command = new DeleteStockLevelCommand(idVo);
commandGateway.sendAndWait(command);
}
}
