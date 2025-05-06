package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteTenant(TenantId idVo, MetaRequest metaRequest) {

DeleteTenantCommand command = new DeleteTenantCommand(idVo);
commandGateway.sendAndWait(command);
}
}
