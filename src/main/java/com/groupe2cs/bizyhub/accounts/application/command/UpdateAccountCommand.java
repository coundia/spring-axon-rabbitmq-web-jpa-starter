package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

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
 	private AccountSyncAt syncAt;
 	private AccountCreatedBy createdBy;
 	private AccountTenant tenant;


}
