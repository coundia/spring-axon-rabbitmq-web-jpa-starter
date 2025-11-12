package com.groupe2cs.bizyhub.message.application.usecase;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.message.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.message.application.command.*;
import com.groupe2cs.bizyhub.message.domain.valueObject.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class MessageSyncApplicationService {

	private final MessageGate gateService;
	private final CommandGateway commandGateway;

	public void syncMessage(MessageSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateMessageCommand command = CreateMessageCommand.builder()
								.code(MessageCode.create(d.getCode()))
								.email(MessageEmail.create(d.getEmail()))
								.phone(MessagePhone.create(d.getPhone()))
								.content(MessageContent.create(d.getContent()))
								.plateforme(MessagePlateforme.create(d.getPlateforme()))
								.source(MessageSource.create(d.getSource()))
								.agent(MessageAgent.create(d.getAgent()))
								.status(MessageStatus.create(d.getStatus()))
								.description(MessageDescription.create(d.getDescription()))
								.isActive(MessageIsActive.create(d.getIsActive()))
								.isDefault(MessageIsDefault.create(d.getIsDefault()))
								.remoteId(MessageRemoteId.create(d.getRemoteId()))
								.localId(MessageLocalId.create(d.getLocalId()))
								.depotAt(MessageDepotAt.create(d.getDepotAt()))
								.syncAt(MessageSyncAt.create(d.getSyncAt()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(MessageTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(MessageCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Message with id " + d.getId());
					}

					UpdateMessageCommand update = UpdateMessageCommand.builder()
							.id(MessageId.create(d.getId()))
							.code(MessageCode.create(d.getCode()))
							.email(MessageEmail.create(d.getEmail()))
							.phone(MessagePhone.create(d.getPhone()))
							.content(MessageContent.create(d.getContent()))
							.plateforme(MessagePlateforme.create(d.getPlateforme()))
							.source(MessageSource.create(d.getSource()))
							.agent(MessageAgent.create(d.getAgent()))
							.status(MessageStatus.create(d.getStatus()))
							.description(MessageDescription.create(d.getDescription()))
							.isActive(MessageIsActive.create(d.getIsActive()))
							.isDefault(MessageIsDefault.create(d.getIsDefault()))
							.remoteId(MessageRemoteId.create(d.getRemoteId()))
							.localId(MessageLocalId.create(d.getLocalId()))
							.depotAt(MessageDepotAt.create(d.getDepotAt()))
							.syncAt(MessageSyncAt.create(d.getSyncAt()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Message with id " + d.getId());
					}

					DeleteMessageCommand delete = DeleteMessageCommand.builder()
						.id(MessageId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
