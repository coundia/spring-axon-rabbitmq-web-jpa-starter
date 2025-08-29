package com.groupe2cs.bizyhub.fileManager.application.usecase;

import com.groupe2cs.bizyhub.fileManager.application.command.CreateFileManagerCommand;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerRequest;
import com.groupe2cs.bizyhub.fileManager.application.dto.FileManagerResponse;
import com.groupe2cs.bizyhub.fileManager.application.mapper.FileManagerMapper;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerCreatedBy;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileManagerCreateApplicationService {
	private final CommandGateway commandGateway;

	public FileManagerResponse createFileManager(FileManagerRequest request,
												 MetaRequest metaRequest
	) {

		CreateFileManagerCommand command = FileManagerMapper.toCommand(
				request
		);

		command.setCreatedBy(FileManagerCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(FileManagerTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return FileManagerMapper.toResponse(command);
	}


}
