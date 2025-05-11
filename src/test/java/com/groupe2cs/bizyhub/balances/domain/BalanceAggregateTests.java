package com.groupe2cs.bizyhub.balances.domain;

import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.balances.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BalanceAggregateTests extends BaseUnitTests {

@Test
void it_should_create_balance_with_valid_values() {
	BalanceId id = BalanceId.create(UUID.randomUUID().toString());
	BalanceName name = BalanceName.create(UUID.randomUUID().toString());
	BalanceCurrency currency = BalanceCurrency.create(UUID.randomUUID().toString());
	BalanceCurrentBalance currentBalance = BalanceCurrentBalance.create(5658.51);
	BalancePreviousBalance previousBalance = BalancePreviousBalance.create(3150.46);
	BalanceLastUpdated lastUpdated = BalanceLastUpdated.create(java.time.Instant.now().plusSeconds(3600));
	BalanceIsDefault isDefault = BalanceIsDefault.create(true);
	BalanceOrdre ordre = BalanceOrdre.create(9);
	BalanceIsArchived isArchived = BalanceIsArchived.create(false);
	BalanceIsAllowDebit isAllowDebit = BalanceIsAllowDebit.create(false);
	BalanceIsAllowCredit isAllowCredit = BalanceIsAllowCredit.create(true);
	BalanceIsExcluTotal isExcluTotal = BalanceIsExcluTotal.create(true);
	BalanceActivateNotification activateNotification = BalanceActivateNotification.create(false);
	BalanceSyncedAt syncedAt = BalanceSyncedAt.create(java.time.Instant.now().plusSeconds(3600));
	BalanceUpdatedAt updatedAt = BalanceUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	BalanceReference reference = BalanceReference.create(UUID.randomUUID().toString());
	BalanceCreatedBy createdBy = BalanceCreatedBy.create(UUID.randomUUID().toString());
	BalanceTenant tenant = BalanceTenant.create(UUID.randomUUID().toString());
	BalanceAggregate aggregateBalanceAggregate = new BalanceAggregate(id, name, currency, currentBalance, previousBalance, lastUpdated, isDefault, ordre, isArchived, isAllowDebit, isAllowCredit, isExcluTotal, activateNotification, syncedAt, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateBalanceAggregate.getId()).isNotNull();
	assertThat(aggregateBalanceAggregate.getId()).isEqualTo(id);
	assertThat(aggregateBalanceAggregate.getName()).isEqualTo(name);
	assertThat(aggregateBalanceAggregate.getCurrency()).isEqualTo(currency);
	assertThat(aggregateBalanceAggregate.getCurrentBalance()).isEqualTo(currentBalance);
	assertThat(aggregateBalanceAggregate.getPreviousBalance()).isEqualTo(previousBalance);
	assertThat(aggregateBalanceAggregate.getLastUpdated()).isEqualTo(lastUpdated);
	assertThat(aggregateBalanceAggregate.getIsDefault()).isEqualTo(isDefault);
	assertThat(aggregateBalanceAggregate.getOrdre()).isEqualTo(ordre);
	assertThat(aggregateBalanceAggregate.getIsArchived()).isEqualTo(isArchived);
	assertThat(aggregateBalanceAggregate.getIsAllowDebit()).isEqualTo(isAllowDebit);
	assertThat(aggregateBalanceAggregate.getIsAllowCredit()).isEqualTo(isAllowCredit);
	assertThat(aggregateBalanceAggregate.getIsExcluTotal()).isEqualTo(isExcluTotal);
	assertThat(aggregateBalanceAggregate.getActivateNotification()).isEqualTo(activateNotification);
	assertThat(aggregateBalanceAggregate.getSyncedAt()).isEqualTo(syncedAt);
	assertThat(aggregateBalanceAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateBalanceAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateBalanceAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateBalanceAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		BalanceIdNotValid error = assertThrows(BalanceIdNotValid.class, () -> BalanceId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		BalanceNameNotValid error = assertThrows(BalanceNameNotValid.class, () -> BalanceName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_currency_is_invalid() {
		BalanceCurrencyNotValid error = assertThrows(BalanceCurrencyNotValid.class, () -> BalanceCurrency.create(""));
		assertThat(error.getMessage()).isEqualTo("Currency is invalid");
		}
		@Test
		void it_should_throw_when_currentBalance_is_invalid() {
		BalanceCurrentBalanceNotValid error = assertThrows(BalanceCurrentBalanceNotValid.class, () -> BalanceCurrentBalance.create(null));
		assertThat(error.getMessage()).isEqualTo("CurrentBalance is invalid");
		}
		@Test
		void it_should_throw_when_previousBalance_is_invalid() {
		BalancePreviousBalanceNotValid error = assertThrows(BalancePreviousBalanceNotValid.class, () -> BalancePreviousBalance.create(null));
		assertThat(error.getMessage()).isEqualTo("PreviousBalance is invalid");
		}
		@Test
		void it_should_throw_when_lastUpdated_is_invalid() {
		BalanceLastUpdatedNotValid error = assertThrows(BalanceLastUpdatedNotValid.class, () -> BalanceLastUpdated.create(null));
		assertThat(error.getMessage()).isEqualTo("LastUpdated is invalid");
		}
		@Test
		void it_should_throw_when_isDefault_is_invalid() {
		BalanceIsDefaultNotValid error = assertThrows(BalanceIsDefaultNotValid.class, () -> BalanceIsDefault.create(null));
		assertThat(error.getMessage()).isEqualTo("IsDefault is invalid");
		}
		@Test
		void it_should_throw_when_ordre_is_invalid() {
		BalanceOrdreNotValid error = assertThrows(BalanceOrdreNotValid.class, () -> BalanceOrdre.create(-1));
		assertThat(error.getMessage()).isEqualTo("Ordre is invalid");
		}
		@Test
		void it_should_throw_when_isArchived_is_invalid() {
		BalanceIsArchivedNotValid error = assertThrows(BalanceIsArchivedNotValid.class, () -> BalanceIsArchived.create(null));
		assertThat(error.getMessage()).isEqualTo("IsArchived is invalid");
		}
		@Test
		void it_should_throw_when_isAllowDebit_is_invalid() {
		BalanceIsAllowDebitNotValid error = assertThrows(BalanceIsAllowDebitNotValid.class, () -> BalanceIsAllowDebit.create(null));
		assertThat(error.getMessage()).isEqualTo("IsAllowDebit is invalid");
		}
		@Test
		void it_should_throw_when_isAllowCredit_is_invalid() {
		BalanceIsAllowCreditNotValid error = assertThrows(BalanceIsAllowCreditNotValid.class, () -> BalanceIsAllowCredit.create(null));
		assertThat(error.getMessage()).isEqualTo("IsAllowCredit is invalid");
		}
		@Test
		void it_should_throw_when_isExcluTotal_is_invalid() {
		BalanceIsExcluTotalNotValid error = assertThrows(BalanceIsExcluTotalNotValid.class, () -> BalanceIsExcluTotal.create(null));
		assertThat(error.getMessage()).isEqualTo("IsExcluTotal is invalid");
		}
		@Test
		void it_should_throw_when_activateNotification_is_invalid() {
		BalanceActivateNotificationNotValid error = assertThrows(BalanceActivateNotificationNotValid.class, () -> BalanceActivateNotification.create(null));
		assertThat(error.getMessage()).isEqualTo("ActivateNotification is invalid");
		}
		@Test
		void it_should_throw_when_syncedAt_is_invalid() {
		BalanceSyncedAtNotValid error = assertThrows(BalanceSyncedAtNotValid.class, () -> BalanceSyncedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("SyncedAt is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		BalanceUpdatedAtNotValid error = assertThrows(BalanceUpdatedAtNotValid.class, () -> BalanceUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		BalanceReferenceNotValid error = assertThrows(BalanceReferenceNotValid.class, () -> BalanceReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		BalanceCreatedByNotValid error = assertThrows(BalanceCreatedByNotValid.class, () -> BalanceCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		BalanceTenantNotValid error = assertThrows(BalanceTenantNotValid.class, () -> BalanceTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
