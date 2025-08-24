package com.groupe2cs.bizyhub.units.application.usecase;
import com.groupe2cs.bizyhub.units.application.command.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.units.application.dto.*;
import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UnitSyncApplicationService {

	private final UnitGate gateService;
	private final CommandGateway commandGateway;

	public void syncUnit(UnitSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateUnitCommand command = CreateUnitCommand.builder()
								.remoteId(UnitRemoteId.create(d.getRemoteId()))
								.code(UnitCode.create(d.getCode()))
								.name(UnitName.create(d.getName()))
								.syncAt(UnitSyncAt.create(d.getSyncAt()))
								.description(UnitDescription.create(d.getDescription()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(UnitTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(UnitCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Unit with id " + d.getId());
					}

					UpdateUnitCommand update = UpdateUnitCommand.builder()
							.id(UnitId.create(d.getId()))
							.remoteId(UnitRemoteId.create(d.getRemoteId()))
							.code(UnitCode.create(d.getCode()))
							.name(UnitName.create(d.getName()))
							.syncAt(UnitSyncAt.create(d.getSyncAt()))
							.description(UnitDescription.create(d.getDescription()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Unit with id " + d.getId());
					}

					DeleteUnitCommand delete = DeleteUnitCommand.builder()
						.id(UnitId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
