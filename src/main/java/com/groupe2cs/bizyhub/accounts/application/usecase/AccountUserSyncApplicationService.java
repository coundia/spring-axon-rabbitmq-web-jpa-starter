package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.application.command.DeleteAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.application.command.UpdateAccountUserCommand;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserSyncRequest;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountUserSyncApplicationService {

	private final AccountUserGate gateService;
	private final CommandGateway commandGateway;
	private final UserRepository userRepository;

	public void syncAccountUser(AccountUserSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateAccountUserCommand command = CreateAccountUserCommand.builder()
							.name(AccountUserName.create(d.getName()))
							.account(AccountUserAccount.create(d.getAccount()))
							.user(AccountUserUser.create(d.getUser()))
							.username(AccountUserUsername.create(d.getUsername()))
							.details(AccountUserDetails.create(d.getDetails()))
							.isActive(AccountUserIsActive.create(d.getIsActive()))
							.updatedAt(AccountUserUpdatedAt.create(d.getUpdatedAt()))
							.reference(AccountUserReference.create(d.getReference()))
							.build();

					String userName = d.getUsername();
					if (userName != null) {
						userName = userName.toLowerCase();
						String userId = userRepository.findByUsernameAndTenantId(userName, metaRequest.getTenantId())
								.stream()
								.findFirst()
								.orElseThrow()
								.getId();
						command.setUser(AccountUserUser.create(userId));
					}

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
							.name(AccountUserName.create(d.getName()))
							.account(AccountUserAccount.create(d.getAccount()))
							.user(AccountUserUser.create(d.getUser()))
							.username(AccountUserUsername.create(d.getUsername()))
							.details(AccountUserDetails.create(d.getDetails()))
							.isActive(AccountUserIsActive.create(d.getIsActive()))
							.updatedAt(AccountUserUpdatedAt.create(d.getUpdatedAt()))
							.reference(AccountUserReference.create(d.getReference()))
							.build();

					String userName = d.getUsername();
					if (userName != null) {
						userName = userName.toLowerCase();
						String userId = userRepository.findByUsernameAndTenantId(userName, metaRequest.getTenantId())
								.stream()
								.findFirst()
								.orElseThrow()
								.getId();
						update.setUser(AccountUserUser.create(userId));
					}

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
