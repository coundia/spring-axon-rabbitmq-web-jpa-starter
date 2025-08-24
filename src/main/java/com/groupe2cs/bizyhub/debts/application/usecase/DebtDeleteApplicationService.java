package com.groupe2cs.bizyhub.debts.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.debts.application.command.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.application.mapper.*;
import com.groupe2cs.bizyhub.debts.application.query.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DebtDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteDebt(DebtId idVo, MetaRequest metaRequest) {

DeleteDebtCommand command = new DeleteDebtCommand(idVo);
commandGateway.sendAndWait(command);
}
}
