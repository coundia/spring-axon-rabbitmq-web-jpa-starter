package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteAccount(AccountId idVo, MetaRequest metaRequest) {

DeleteAccountCommand command = new DeleteAccountCommand(idVo);
commandGateway.sendAndWait(command);
}
}
