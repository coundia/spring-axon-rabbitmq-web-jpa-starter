package com.groupe2cs.bizyhub.debts.domain.event;

	import com.groupe2cs.bizyhub.debts.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DebtCreatedEvent implements Serializable {

	private DebtId id;
	private DebtRemoteId remoteId;
	private DebtLocalId localId;
	private DebtCode code;
	private DebtNotes notes;
	private DebtBalance balance;
	private DebtBalanceDebt balanceDebt;
	private DebtDueDate dueDate;
	private DebtStatuses statuses;
	private DebtAccount account;
	private DebtSyncAt syncAt;
	private DebtCustomer customer;
	private DebtIsActive isActive;
	private DebtCreatedBy createdBy;
	private DebtTenant tenant;



}
