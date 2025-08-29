package com.groupe2cs.bizyhub.fileManager.application.usecase;

import com.groupe2cs.bizyhub.fileManager.application.command.*;
import com.groupe2cs.bizyhub.fileManager.application.query.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.fileManager.application.mapper.*;
import com.groupe2cs.bizyhub.fileManager.application.dto.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileManagerUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public FileManagerResponse updateFileManager(FileManagerId id,FileManagerRequest request,
MetaRequest metaRequest
){

UpdateFileManagerCommand command = FileManagerMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(FileManagerCreatedBy.create(metaRequest.getUserId()));
command.setTenant(FileManagerTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return FileManagerMapper.toResponse(command);
}

}
