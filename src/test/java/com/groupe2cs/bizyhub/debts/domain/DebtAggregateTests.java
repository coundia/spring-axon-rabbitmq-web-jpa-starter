package com.groupe2cs.bizyhub.debts.domain;

import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceDebtNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtBalanceNotValid;
import com.groupe2cs.bizyhub.debts.domain.exception.DebtIdNotValid;
import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DebtAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_debt_with_valid_values() {
		DebtId id = DebtId.create(UUID.randomUUID().toString());
		DebtRemoteId remoteId = DebtRemoteId.create(UUID.randomUUID().toString());
		DebtLocalId localId = DebtLocalId.create(UUID.randomUUID().toString());
		DebtCode code = DebtCode.create(UUID.randomUUID().toString());
		DebtNotes notes = DebtNotes.create(UUID.randomUUID().toString());
		DebtBalance balance = DebtBalance.create(7877.49);
		DebtBalanceDebt balanceDebt = DebtBalanceDebt.create(2614.25);
		DebtDueDate dueDate = DebtDueDate.create(java.time.Instant.now().plusSeconds(3600));
		DebtStatuses statuses = DebtStatuses.create(UUID.randomUUID().toString());
		DebtAccount account = DebtAccount.create(UUID.randomUUID().toString());
		DebtSyncAt syncAt = DebtSyncAt.create(java.time.Instant.now().plusSeconds(3600));
		DebtCustomer customer = DebtCustomer.create(UUID.randomUUID().toString());
		DebtIsActive isActive = DebtIsActive.create(true);
		DebtCreatedBy createdBy = DebtCreatedBy.create(UUID.randomUUID().toString());
		DebtTenant tenant = DebtTenant.create(UUID.randomUUID().toString());
		DebtAggregate
				aggregateDebtAggregate =
				new DebtAggregate(id,
						remoteId,
						localId,
						code,
						notes,
						balance,
						balanceDebt,
						dueDate,
						statuses,
						account,
						syncAt,
						customer,
						isActive,
						createdBy,
						tenant);
		assertThat(aggregateDebtAggregate.getId()).isNotNull();
		assertThat(aggregateDebtAggregate.getId()).isEqualTo(id);
		assertThat(aggregateDebtAggregate.getRemoteId()).isEqualTo(remoteId);
		assertThat(aggregateDebtAggregate.getLocalId()).isEqualTo(localId);
		assertThat(aggregateDebtAggregate.getCode()).isEqualTo(code);
		assertThat(aggregateDebtAggregate.getNotes()).isEqualTo(notes);
		assertThat(aggregateDebtAggregate.getBalance()).isEqualTo(balance);
		assertThat(aggregateDebtAggregate.getBalanceDebt()).isEqualTo(balanceDebt);
		assertThat(aggregateDebtAggregate.getDueDate()).isEqualTo(dueDate);
		assertThat(aggregateDebtAggregate.getStatuses()).isEqualTo(statuses);
		assertThat(aggregateDebtAggregate.getAccount()).isEqualTo(account);
		assertThat(aggregateDebtAggregate.getSyncAt()).isEqualTo(syncAt);
		assertThat(aggregateDebtAggregate.getCustomer()).isEqualTo(customer);
		assertThat(aggregateDebtAggregate.getIsActive()).isEqualTo(isActive);
		assertThat(aggregateDebtAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateDebtAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		DebtIdNotValid error = assertThrows(DebtIdNotValid.class, () -> DebtId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_balance_is_invalid() {
		DebtBalanceNotValid error = assertThrows(DebtBalanceNotValid.class, () -> DebtBalance.create(null));
		assertThat(error.getMessage()).isEqualTo("Balance is invalid");
	}

	@Test
	void it_should_throw_when_balanceDebt_is_invalid() {
		DebtBalanceDebtNotValid error = assertThrows(DebtBalanceDebtNotValid.class, () -> DebtBalanceDebt.create(null));
		assertThat(error.getMessage()).isEqualTo("BalanceDebt is invalid");
	}

}
