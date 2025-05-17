package com.groupe2cs.bizyhub.accounts.application.usecase;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AccountSyncApplicationService {

	private final AccountGate gateService;
	private final CommandGateway commandGateway;

	public void syncAccount(AccountSyncRequest request, MetaRequest metaRequest) {
		for (var d : request.getDeltas()) {
			switch (d.getType()) {
				case "CREATE" -> {


					CreateAccountCommand command = CreateAccountCommand.builder()
								.name(AccountName.create(d.getName()))
								.currency(AccountCurrency.create(d.getCurrency()))
								.currentBalance(AccountCurrentBalance.create(d.getCurrentBalance()))
								.previousBalance(AccountPreviousBalance.create(d.getPreviousBalance()))
								.details(AccountDetails.create(d.getDetails()))
								.isActive(AccountIsActive.create(d.getIsActive()))
								.updatedAt(AccountUpdatedAt.create(d.getUpdatedAt()))
								.reference(AccountReference.create(d.getReference()))
						.build();


					if (metaRequest.getTenantId() != null) {
						command.setTenant(AccountTenant.create(metaRequest.getTenantId()));
					}

					if (metaRequest.getUserId() != null) {
						command.setCreatedBy(AccountCreatedBy.create(metaRequest.getUserId()));
					}

					commandGateway.sendAndWait(command);
				}

				case "UPDATE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to update Account with id " + d.getId());
					}

					UpdateAccountCommand update = UpdateAccountCommand.builder()
							.id(AccountId.create(d.getId()))
							.name(AccountName.create(d.getName()))
							.currency(AccountCurrency.create(d.getCurrency()))
							.currentBalance(AccountCurrentBalance.create(d.getCurrentBalance()))
							.previousBalance(AccountPreviousBalance.create(d.getPreviousBalance()))
							.details(AccountDetails.create(d.getDetails()))
							.isActive(AccountIsActive.create(d.getIsActive()))
							.updatedAt(AccountUpdatedAt.create(d.getUpdatedAt()))
							.reference(AccountReference.create(d.getReference()))
						.build();


					commandGateway.sendAndWait(update);
				}

				case "DELETE" -> {
					if (!gateService.canDelete(metaRequest.getUserId(), d.getId()) && !metaRequest.getIsAdmin()) {
						throw new RuntimeException("Unauthorized to delete Account with id " + d.getId());
					}

					DeleteAccountCommand delete = DeleteAccountCommand.builder()
						.id(AccountId.create(d.getId()))
						.build();

					commandGateway.sendAndWait(delete);
				}
			}
		}
	}
}
