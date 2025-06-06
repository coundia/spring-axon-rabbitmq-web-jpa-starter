package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.accounts.application.command.CreateAccountCommand;
import com.groupe2cs.bizyhub.accounts.application.command.DeleteAccountCommand;
import com.groupe2cs.bizyhub.accounts.application.command.UpdateAccountCommand;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountSyncRequest;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

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
