package com.groupe2cs.bizyhub.balances.application.usecase;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.balances.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.balances.application.command.*;
import com.groupe2cs.bizyhub.balances.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BalanceCreateApplicationService {
private final CommandGateway commandGateway;

public BalanceResponse createBalance(BalanceRequest request,
MetaRequest metaRequest
){

CreateBalanceCommand command = BalanceMapper.toCommand(
request
);

command.setCreatedBy(BalanceCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(BalanceTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return BalanceMapper.toResponse(command);
}


}
