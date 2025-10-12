package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAccountCommand implements Serializable {
	@TargetAggregateIdentifier
	private AccountId id;
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


}
