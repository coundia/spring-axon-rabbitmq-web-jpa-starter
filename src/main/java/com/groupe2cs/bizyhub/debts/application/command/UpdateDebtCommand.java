package com.groupe2cs.bizyhub.debts.application.command;

import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateDebtCommand implements Serializable {
	@TargetAggregateIdentifier
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
