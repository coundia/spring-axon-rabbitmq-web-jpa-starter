package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.mapper.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SyncStateCreateApplicationService {
private final CommandGateway commandGateway;

public SyncStateResponse createSyncState(SyncStateRequest request,
MetaRequest metaRequest
){

CreateSyncStateCommand command = SyncStateMapper.toCommand(
request
);

command.setCreatedBy(SyncStateCreatedBy.create(metaRequest.getUserId()));
command.setTenant(SyncStateTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return SyncStateMapper.toResponse(command);
}


}
