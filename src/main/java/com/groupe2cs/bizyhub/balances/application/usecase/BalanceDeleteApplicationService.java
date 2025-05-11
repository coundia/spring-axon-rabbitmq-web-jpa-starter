package com.groupe2cs.bizyhub.balances.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.balances.application.command.*;
import com.groupe2cs.bizyhub.balances.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.balances.application.dto.*;
import com.groupe2cs.bizyhub.balances.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteBalance(BalanceId idVo, MetaRequest metaRequest) {

DeleteBalanceCommand command = new DeleteBalanceCommand(idVo);
commandGateway.sendAndWait(command);
}
}
