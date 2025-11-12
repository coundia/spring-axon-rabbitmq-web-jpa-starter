package com.groupe2cs.bizyhub.fileManager.application.usecase;

import com.groupe2cs.bizyhub.fileManager.application.command.UpdateFileManagerCommand;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerRequest;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerResponse;
import com.groupe2cs.bizyhub.fileManager.application.mapper.FileManagerMapper;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerCreatedBy;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerId;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileManagerUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public FileManagerResponse updateFileManager(FileManagerId id, FileManagerRequest request,
												 MetaRequest metaRequest
	) {

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
