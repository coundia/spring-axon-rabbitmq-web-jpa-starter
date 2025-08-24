package com.groupe2cs.bizyhub.units.application.usecase;

import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.units.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnitCreateApplicationService {
private final CommandGateway commandGateway;

public UnitResponse createUnit(UnitRequest request,
MetaRequest metaRequest
){

CreateUnitCommand command = UnitMapper.toCommand(
request
);

command.setCreatedBy(UnitCreatedBy.create(metaRequest.getUserId()));
command.setTenant(UnitTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return UnitMapper.toResponse(command);
}


}
