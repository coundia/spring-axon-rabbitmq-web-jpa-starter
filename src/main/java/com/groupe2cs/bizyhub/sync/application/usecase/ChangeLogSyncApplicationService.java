package com.groupe2cs.bizyhub.sync.application.usecase;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;
import com.groupe2cs.bizyhub.sync.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ChangeLogSyncApplicationService {

	private final ChangeLogGate gateService;
	private final CommandGateway commandGateway;

	public void syncChangeLog(ChangeLogSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateChangeLogCommand command = CreateChangeLogCommand.builder()
								.entityTable(ChangeLogEntityTable.create(d.getEntityTable()))
								.account(ChangeLogAccount.create(d.getAccount()))
								.remoteId(ChangeLogRemoteId.create(d.getRemoteId()))
								.localId(ChangeLogLocalId.create(d.getLocalId()))
								.operation(ChangeLogOperation.create(d.getOperation()))
								.payload(ChangeLogPayload.create(d.getPayload()))
								.status(ChangeLogStatus.create(d.getStatus()))
								.syncAt(ChangeLogSyncAt.create(d.getSyncAt()))
								.attempts(ChangeLogAttempts.create(d.getAttempts()))
								.error(ChangeLogError.create(d.getError()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(ChangeLogTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(ChangeLogCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update ChangeLog with id " + d.getId());
					}

					UpdateChangeLogCommand update = UpdateChangeLogCommand.builder()
							.id(ChangeLogId.create(d.getId()))
							.entityTable(ChangeLogEntityTable.create(d.getEntityTable()))
							.account(ChangeLogAccount.create(d.getAccount()))
							.remoteId(ChangeLogRemoteId.create(d.getRemoteId()))
							.localId(ChangeLogLocalId.create(d.getLocalId()))
							.operation(ChangeLogOperation.create(d.getOperation()))
							.payload(ChangeLogPayload.create(d.getPayload()))
							.status(ChangeLogStatus.create(d.getStatus()))
							.syncAt(ChangeLogSyncAt.create(d.getSyncAt()))
							.attempts(ChangeLogAttempts.create(d.getAttempts()))
							.error(ChangeLogError.create(d.getError()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete ChangeLog with id " + d.getId());
					}

					DeleteChangeLogCommand delete = DeleteChangeLogCommand.builder()
						.id(ChangeLogId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
