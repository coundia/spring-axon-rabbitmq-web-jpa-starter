package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private AccountId id = AccountId.create(UUID.randomUUID().toString());
	private AccountCode code;
	private AccountName name;
	private AccountStatus status;
	private AccountCurrency currency;
	private AccountTypeAccount typeAccount;
	private AccountBalance balance;
	private AccountBalancePrev balancePrev;
	private AccountBalanceBlocked balanceBlocked;
	private AccountBalanceInit balanceInit;
	private AccountBalanceGoal balanceGoal;
	private AccountBalanceLimit balanceLimit;
	private AccountDescription description;
	private AccountIsActive isActive;
	private AccountIsDefault isDefault;
	private AccountRemoteId remoteId;
	private AccountLocalId localId;
	private AccountSyncAt syncAt;
	private AccountCreatedBy createdBy;
	private AccountTenant tenant;

	public CreateAccountCommand(

			AccountCode code,
			AccountName name,
			AccountStatus status,
			AccountCurrency currency,
			AccountTypeAccount typeAccount,
			AccountBalance balance,
			AccountBalancePrev balancePrev,
			AccountBalanceBlocked balanceBlocked,
			AccountBalanceInit balanceInit,
			AccountBalanceGoal balanceGoal,
			AccountBalanceLimit balanceLimit,
			AccountDescription description,
			AccountIsActive isActive,
			AccountIsDefault isDefault,
			AccountRemoteId remoteId,
			AccountLocalId localId,
			AccountSyncAt syncAt,
			AccountCreatedBy createdBy,
			AccountTenant tenant
	) {
		this.id = AccountId.create(UUID.randomUUID().toString());

		this.code = code;
		this.name = name;
		this.status = status;
		this.currency = currency;
		this.typeAccount = typeAccount;
		this.balance = balance;
		this.balancePrev = balancePrev;
		this.balanceBlocked = balanceBlocked;
		this.balanceInit = balanceInit;
		this.balanceGoal = balanceGoal;
		this.balanceLimit = balanceLimit;
		this.description = description;
		this.isActive = isActive;
		this.isDefault = isDefault;
		this.remoteId = remoteId;
		this.localId = localId;
		this.syncAt = syncAt;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
