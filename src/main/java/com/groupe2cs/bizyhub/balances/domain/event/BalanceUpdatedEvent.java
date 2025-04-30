package com.groupe2cs.bizyhub.balances.domain.event;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BalanceUpdatedEvent implements Serializable {

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
	private BalanceCreatedBy createdBy;
	private BalanceTenant tenant;


}
