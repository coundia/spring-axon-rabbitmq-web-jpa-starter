package com.groupe2cs.bizyhub.units.application.usecase;

import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.application.command.*;
import com.groupe2cs.bizyhub.units.application.mapper.*;
import com.groupe2cs.bizyhub.units.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UnitUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public UnitResponse updateUnit(UnitId id,UnitRequest request,
MetaRequest metaRequest
){

UpdateUnitCommand command = UnitMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(UnitCreatedBy.create(metaRequest.getUserId()));
command.setTenant(UnitTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return UnitMapper.toResponse(command);
}

}
