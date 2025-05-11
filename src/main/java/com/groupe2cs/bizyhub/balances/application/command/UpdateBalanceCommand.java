package com.groupe2cs.bizyhub.balances.application.command;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;

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
public class UpdateBalanceCommand implements Serializable {
@TargetAggregateIdentifier
	private BalanceId id;
 	private BalanceName name;
 	private BalanceCurrency currency;
 	private BalanceCurrentBalance currentBalance;
 	private BalancePreviousBalance previousBalance;
 	private BalanceLastUpdated lastUpdated;
 	private BalanceIsDefault isDefault;
 	private BalanceOrdre ordre;
 	private BalanceIsArchived isArchived;
 	private BalanceIsAllowDebit isAllowDebit;
 	private BalanceIsAllowCredit isAllowCredit;
 	private BalanceIsExcluTotal isExcluTotal;
 	private BalanceActivateNotification activateNotification;
 	private BalanceSyncedAt syncedAt;
 	private BalanceUpdatedAt updatedAt;
 	private BalanceReference reference;
 	private BalanceCreatedBy createdBy;
 	private BalanceTenant tenant;


}
