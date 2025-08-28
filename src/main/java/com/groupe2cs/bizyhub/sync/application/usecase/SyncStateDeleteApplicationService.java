package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sync.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SyncStateDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteSyncState(SyncStateId idVo, MetaRequest metaRequest) {

DeleteSyncStateCommand command = new DeleteSyncStateCommand(idVo);
commandGateway.sendAndWait(command);
}
}
