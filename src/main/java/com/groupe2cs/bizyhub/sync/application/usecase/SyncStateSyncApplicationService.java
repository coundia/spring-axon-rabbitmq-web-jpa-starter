package com.groupe2cs.bizyhub.sync.application.usecase;
import com.groupe2cs.bizyhub.sync.application.command.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.sync.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SyncStateSyncApplicationService {

	private final SyncStateGate gateService;
	private final CommandGateway commandGateway;

	public void syncSyncState(SyncStateSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateSyncStateCommand command = CreateSyncStateCommand.builder()
								.entityTable(SyncStateEntityTable.create(d.getEntityTable()))
								.remoteId(SyncStateRemoteId.create(d.getRemoteId()))
								.localId(SyncStateLocalId.create(d.getLocalId()))
								.syncAt(SyncStateSyncAt.create(d.getSyncAt()))
								.lastSyncAt(SyncStateLastSyncAt.create(d.getLastSyncAt()))
								.lastCursor(SyncStateLastCursor.create(d.getLastCursor()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(SyncStateTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(SyncStateCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update SyncState with id " + d.getId());
					}

					UpdateSyncStateCommand update = UpdateSyncStateCommand.builder()
							.id(SyncStateId.create(d.getId()))
							.entityTable(SyncStateEntityTable.create(d.getEntityTable()))
							.remoteId(SyncStateRemoteId.create(d.getRemoteId()))
							.localId(SyncStateLocalId.create(d.getLocalId()))
							.syncAt(SyncStateSyncAt.create(d.getSyncAt()))
							.lastSyncAt(SyncStateLastSyncAt.create(d.getLastSyncAt()))
							.lastCursor(SyncStateLastCursor.create(d.getLastCursor()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete SyncState with id " + d.getId());
					}

					DeleteSyncStateCommand delete = DeleteSyncStateCommand.builder()
						.id(SyncStateId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
