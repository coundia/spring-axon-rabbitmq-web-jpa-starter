package com.groupe2cs.bizyhub.units.application.usecase;

import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.application.command.*;
import com.groupe2cs.bizyhub.units.application.mapper.*;
import com.groupe2cs.bizyhub.units.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnitDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteUnit(UnitId idVo, MetaRequest metaRequest) {

DeleteUnitCommand command = new DeleteUnitCommand(idVo);
commandGateway.sendAndWait(command);
}
}
