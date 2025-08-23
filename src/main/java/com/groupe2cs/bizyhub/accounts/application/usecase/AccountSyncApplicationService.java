package com.groupe2cs.bizyhub.accounts.application.usecase;
import com.groupe2cs.bizyhub.security.infrastructure.repository.UserRepository;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;

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
								.code(AccountCode.create(d.getCode()))
								.name(AccountName.create(d.getName()))
								.status(AccountStatus.create(d.getStatus()))
								.currency(AccountCurrency.create(d.getCurrency()))
								.typeAccount(AccountTypeAccount.create(d.getTypeAccount()))
								.balance(AccountBalance.create(d.getBalance()))
								.balancePrev(AccountBalancePrev.create(d.getBalancePrev()))
								.balanceBlocked(AccountBalanceBlocked.create(d.getBalanceBlocked()))
								.balanceInit(AccountBalanceInit.create(d.getBalanceInit()))
								.balanceGoal(AccountBalanceGoal.create(d.getBalanceGoal()))
								.balanceLimit(AccountBalanceLimit.create(d.getBalanceLimit()))
								.description(AccountDescription.create(d.getDescription()))
								.isActive(AccountIsActive.create(d.getIsActive()))
								.isDefault(AccountIsDefault.create(d.getIsDefault()))
								.syncAt(AccountSyncAt.create(d.getSyncAt()))
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
							.code(AccountCode.create(d.getCode()))
							.name(AccountName.create(d.getName()))
							.status(AccountStatus.create(d.getStatus()))
							.currency(AccountCurrency.create(d.getCurrency()))
							.typeAccount(AccountTypeAccount.create(d.getTypeAccount()))
							.balance(AccountBalance.create(d.getBalance()))
							.balancePrev(AccountBalancePrev.create(d.getBalancePrev()))
							.balanceBlocked(AccountBalanceBlocked.create(d.getBalanceBlocked()))
							.balanceInit(AccountBalanceInit.create(d.getBalanceInit()))
							.balanceGoal(AccountBalanceGoal.create(d.getBalanceGoal()))
							.balanceLimit(AccountBalanceLimit.create(d.getBalanceLimit()))
							.description(AccountDescription.create(d.getDescription()))
							.isActive(AccountIsActive.create(d.getIsActive()))
							.isDefault(AccountIsDefault.create(d.getIsDefault()))
							.syncAt(AccountSyncAt.create(d.getSyncAt()))
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
