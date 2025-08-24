package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.sync.application.mapper.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChangeLogCreateApplicationService {
private final CommandGateway commandGateway;

public ChangeLogResponse createChangeLog(ChangeLogRequest request,
MetaRequest metaRequest
){

CreateChangeLogCommand command = ChangeLogMapper.toCommand(
request
);

command.setCreatedBy(ChangeLogCreatedBy.create(metaRequest.getUserId()));
command.setTenant(ChangeLogTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return ChangeLogMapper.toResponse(command);
}


}
