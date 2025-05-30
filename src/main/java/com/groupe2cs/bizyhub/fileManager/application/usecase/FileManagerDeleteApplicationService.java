package com.groupe2cs.bizyhub.fileManager.application.usecase;

import com.groupe2cs.bizyhub.fileManager.application.command.DeleteFileManagerCommand;
import com.groupe2cs.bizyhub.fileManager.domain.valueObject.FileManagerId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileManagerDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteFileManager(FileManagerId idVo, MetaRequest metaRequest) {

		DeleteFileManagerCommand command = new DeleteFileManagerCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
