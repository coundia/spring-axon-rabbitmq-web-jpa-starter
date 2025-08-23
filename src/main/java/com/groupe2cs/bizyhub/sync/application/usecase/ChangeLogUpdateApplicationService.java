package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sync.application.command.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.application.mapper.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChangeLogUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public ChangeLogResponse updateChangeLog(ChangeLogId id,ChangeLogRequest request,
MetaRequest metaRequest
){

UpdateChangeLogCommand command = ChangeLogMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(ChangeLogCreatedBy.create(metaRequest.getUserId()));
command.setTenant(ChangeLogTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return ChangeLogMapper.toResponse(command);
}

}
