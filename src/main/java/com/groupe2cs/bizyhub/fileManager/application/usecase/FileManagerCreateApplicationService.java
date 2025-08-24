package com.groupe2cs.bizyhub.fileManager.application.usecase;

import com.groupe2cs.bizyhub.fileManager.application.mapper.*;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.fileManager.application.command.*;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileManagerCreateApplicationService {
private final CommandGateway commandGateway;

public FileManagerResponse createFileManager(FileManagerRequest request,
MetaRequest metaRequest
){

CreateFileManagerCommand command = FileManagerMapper.toCommand(
request
);

command.setCreatedBy(FileManagerCreatedBy.create(metaRequest.getUserId()));
command.setTenant(FileManagerTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return FileManagerMapper.toResponse(command);
}


}
