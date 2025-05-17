package com.groupe2cs.bizyhub.transactions.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.transactions.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TransactionUserSyncApplicationService {

	private final TransactionUserGate gateService;
	private final CommandGateway commandGateway;
	private final UserRepository userRepository;

	public void syncTransactionUser(TransactionUserSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateTransactionUserCommand command = CreateTransactionUserCommand.builder()
								.name(TransactionUserName.create(d.getName()))
								.transaction(TransactionUserTransaction.create(d.getTransaction()))
								.user(TransactionUserUser.create(d.getUser()))
								.username(TransactionUserUsername.create(d.getUsername()))
								.details(TransactionUserDetails.create(d.getDetails()))
								.isActive(TransactionUserIsActive.create(d.getIsActive()))
								.updatedAt(TransactionUserUpdatedAt.create(d.getUpdatedAt()))
								.reference(TransactionUserReference.create(d.getReference()))
						.build();

					String userName = d.getUsername();
					if (userName != null) {
						userName = userName.toLowerCase();
						String userId = userRepository.findByUsernameAndTenantId(userName, metaRequest.getTenantId())
							.stream()
							.findFirst()
							.orElseThrow()
							.getId();
						command.setUser(TransactionUserUser.create(userId));
					}

					if (metaRequest.getTenantId() != null) {
						command.setTenant(TransactionUserTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(TransactionUserCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update TransactionUser with id " + d.getId());
					}

					UpdateTransactionUserCommand update = UpdateTransactionUserCommand.builder()
							.id(TransactionUserId.create(d.getId()))
							.name(TransactionUserName.create(d.getName()))
							.transaction(TransactionUserTransaction.create(d.getTransaction()))
							.user(TransactionUserUser.create(d.getUser()))
							.username(TransactionUserUsername.create(d.getUsername()))
							.details(TransactionUserDetails.create(d.getDetails()))
							.isActive(TransactionUserIsActive.create(d.getIsActive()))
							.updatedAt(TransactionUserUpdatedAt.create(d.getUpdatedAt()))
							.reference(TransactionUserReference.create(d.getReference()))
						.build();

					String userName = d.getUsername();
					if (userName != null) {
						userName = userName.toLowerCase();
						String userId = userRepository.findByUsernameAndTenantId(userName, metaRequest.getTenantId())
							.stream()
							.findFirst()
							.orElseThrow()
							.getId();
						update.setUser(TransactionUserUser.create(userId));
					}

					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete TransactionUser with id " + d.getId());
					}

					DeleteTransactionUserCommand delete = DeleteTransactionUserCommand.builder()
						.id(TransactionUserId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
