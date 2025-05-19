package com.groupe2cs.bizyhub.accounts.domain;

import static org.assertj.core.api.Assertions.assertThat;
import com.groupe2cs.bizyhub.accounts.domain.exception.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.UUID;


public class AccountAggregateTests extends BaseUnitTests {

@Test
void it_should_create_account_with_valid_values() {
	AccountId id = AccountId.create(UUID.randomUUID().toString());
	AccountName name = AccountName.create(UUID.randomUUID().toString());
	AccountCurrency currency = AccountCurrency.create(UUID.randomUUID().toString());
	AccountCurrentBalance currentBalance = AccountCurrentBalance.create(6812.77);
	AccountPreviousBalance previousBalance = AccountPreviousBalance.create(4990.02);
	AccountDetails details = AccountDetails.create(UUID.randomUUID().toString());
	AccountIsActive isActive = AccountIsActive.create(true);
	AccountUpdatedAt updatedAt = AccountUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	AccountReference reference = AccountReference.create(UUID.randomUUID().toString());
	AccountCreatedBy createdBy = AccountCreatedBy.create(UUID.randomUUID().toString());
	AccountTenant tenant = AccountTenant.create(UUID.randomUUID().toString());
	AccountAggregate aggregateAccountAggregate = new AccountAggregate(id, name, currency, currentBalance, previousBalance, details, isActive, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateAccountAggregate.getId()).isNotNull();
	assertThat(aggregateAccountAggregate.getId()).isEqualTo(id);
	assertThat(aggregateAccountAggregate.getName()).isEqualTo(name);
	assertThat(aggregateAccountAggregate.getCurrency()).isEqualTo(currency);
	assertThat(aggregateAccountAggregate.getCurrentBalance()).isEqualTo(currentBalance);
	assertThat(aggregateAccountAggregate.getPreviousBalance()).isEqualTo(previousBalance);
	assertThat(aggregateAccountAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateAccountAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateAccountAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateAccountAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateAccountAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateAccountAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		AccountIdNotValid error = assertThrows(AccountIdNotValid.class, () -> AccountId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		AccountNameNotValid error = assertThrows(AccountNameNotValid.class, () -> AccountName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_currency_is_invalid() {
		AccountCurrencyNotValid error = assertThrows(AccountCurrencyNotValid.class, () -> AccountCurrency.create(""));
		assertThat(error.getMessage()).isEqualTo("Currency is invalid");
		}
		@Test
		void it_should_throw_when_currentBalance_is_invalid() {
		AccountCurrentBalanceNotValid error = assertThrows(AccountCurrentBalanceNotValid.class, () -> AccountCurrentBalance.create(null));
		assertThat(error.getMessage()).isEqualTo("CurrentBalance is invalid");
		}
		@Test
		void it_should_throw_when_previousBalance_is_invalid() {
		AccountPreviousBalanceNotValid error = assertThrows(AccountPreviousBalanceNotValid.class, () -> AccountPreviousBalance.create(null));
		assertThat(error.getMessage()).isEqualTo("PreviousBalance is invalid");
		}
		@Test
		void it_should_throw_when_details_is_invalid() {
		AccountDetailsNotValid error = assertThrows(AccountDetailsNotValid.class, () -> AccountDetails.create(""));
		assertThat(error.getMessage()).isEqualTo("Details is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		AccountIsActiveNotValid error = assertThrows(AccountIsActiveNotValid.class, () -> AccountIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		AccountUpdatedAtNotValid error = assertThrows(AccountUpdatedAtNotValid.class, () -> AccountUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		AccountReferenceNotValid error = assertThrows(AccountReferenceNotValid.class, () -> AccountReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		AccountCreatedByNotValid error = assertThrows(AccountCreatedByNotValid.class, () -> AccountCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		AccountTenantNotValid error = assertThrows(AccountTenantNotValid.class, () -> AccountTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
