package com.groupe2cs.bizyhub.debts.application.command;

import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDebtCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private DebtId id = DebtId.create(UUID.randomUUID().toString());
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

	public CreateDebtCommand(

			DebtRemoteId remoteId,
			DebtLocalId localId,
			DebtCode code,
			DebtNotes notes,
			DebtBalance balance,
			DebtBalanceDebt balanceDebt,
			DebtDueDate dueDate,
			DebtStatuses statuses,
			DebtAccount account,
			DebtSyncAt syncAt,
			DebtCustomer customer,
			DebtIsActive isActive,
			DebtCreatedBy createdBy,
			DebtTenant tenant
	) {
		this.id = DebtId.create(UUID.randomUUID().toString());

		this.remoteId = remoteId;
		this.localId = localId;
		this.code = code;
		this.notes = notes;
		this.balance = balance;
		this.balanceDebt = balanceDebt;
		this.dueDate = dueDate;
		this.statuses = statuses;
		this.account = account;
		this.syncAt = syncAt;
		this.customer = customer;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
