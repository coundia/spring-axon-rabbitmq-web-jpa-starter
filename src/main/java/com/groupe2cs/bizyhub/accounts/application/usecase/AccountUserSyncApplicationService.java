package com.groupe2cs.bizyhub.accounts.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.accounts.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AccountUserSyncApplicationService {

	private final AccountUserGate gateService;
	private final CommandGateway commandGateway;

	public void syncAccountUser(AccountUserSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateAccountUserCommand command = CreateAccountUserCommand.builder()
								.account(AccountUserAccount.create(d.getAccount()))
								.user(AccountUserUser.create(d.getUser()))
								.identity(AccountUserIdentity.create(d.getIdentity()))
								.phone(AccountUserPhone.create(d.getPhone()))
								.email(AccountUserEmail.create(d.getEmail()))
								.role(AccountUserRole.create(d.getRole()))
								.status(AccountUserStatus.create(d.getStatus()))
								.invitedBy(AccountUserInvitedBy.create(d.getInvitedBy()))
								.syncAt(AccountUserSyncAt.create(d.getSyncAt()))
								.acceptedAt(AccountUserAcceptedAt.create(d.getAcceptedAt()))
								.revokedAt(AccountUserRevokedAt.create(d.getRevokedAt()))
								.message(AccountUserMessage.create(d.getMessage()))
								.remoteId(AccountUserRemoteId.create(d.getRemoteId()))
								.localId(AccountUserLocalId.create(d.getLocalId()))
								.isActive(AccountUserIsActive.create(d.getIsActive()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(AccountUserTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(AccountUserCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update AccountUser with id " + d.getId());
					}

					UpdateAccountUserCommand update = UpdateAccountUserCommand.builder()
							.id(AccountUserId.create(d.getId()))
							.account(AccountUserAccount.create(d.getAccount()))
							.user(AccountUserUser.create(d.getUser()))
							.identity(AccountUserIdentity.create(d.getIdentity()))
							.phone(AccountUserPhone.create(d.getPhone()))
							.email(AccountUserEmail.create(d.getEmail()))
							.role(AccountUserRole.create(d.getRole()))
							.status(AccountUserStatus.create(d.getStatus()))
							.invitedBy(AccountUserInvitedBy.create(d.getInvitedBy()))
							.syncAt(AccountUserSyncAt.create(d.getSyncAt()))
							.acceptedAt(AccountUserAcceptedAt.create(d.getAcceptedAt()))
							.revokedAt(AccountUserRevokedAt.create(d.getRevokedAt()))
							.message(AccountUserMessage.create(d.getMessage()))
							.remoteId(AccountUserRemoteId.create(d.getRemoteId()))
							.localId(AccountUserLocalId.create(d.getLocalId()))
							.isActive(AccountUserIsActive.create(d.getIsActive()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete AccountUser with id " + d.getId());
					}

					DeleteAccountUserCommand delete = DeleteAccountUserCommand.builder()
						.id(AccountUserId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
