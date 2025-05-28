package com.groupe2cs.bizyhub.settings.application.usecase;

import com.groupe2cs.bizyhub.settings.application.command.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.settings.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.settings.application.dto.*;
import com.groupe2cs.bizyhub.settings.application.query.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SettingDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteSetting(SettingId idVo, MetaRequest metaRequest) {

DeleteSettingCommand command = new DeleteSettingCommand(idVo);
commandGateway.sendAndWait(command);
}
}
