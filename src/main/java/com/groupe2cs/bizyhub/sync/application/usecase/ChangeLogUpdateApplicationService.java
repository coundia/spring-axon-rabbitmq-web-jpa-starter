package com.groupe2cs.bizyhub.sync.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import com.groupe2cs.bizyhub.sync.application.command.UpdateChangeLogCommand;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogRequest;
import com.groupe2cs.bizyhub.sync.application.dto.ChangeLogResponse;
import com.groupe2cs.bizyhub.sync.application.mapper.ChangeLogMapper;
import com.groupe2cs.bizyhub.sync.domain.valueObject.ChangeLogCreatedBy;
import com.groupe2cs.bizyhub.sync.domain.valueObject.ChangeLogId;
import com.groupe2cs.bizyhub.sync.domain.valueObject.ChangeLogTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeLogUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public ChangeLogResponse updateChangeLog(ChangeLogId id, ChangeLogRequest request,
											 MetaRequest metaRequest
	) {

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
