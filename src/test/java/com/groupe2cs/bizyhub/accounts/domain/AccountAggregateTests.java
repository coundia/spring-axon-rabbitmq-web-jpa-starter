package com.groupe2cs.bizyhub.accounts.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.domain.exception.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;


public class AccountAggregateTests extends BaseUnitTests {

@Test
void it_should_create_account_with_valid_values() {
	AccountId id = AccountId.create(UUID.randomUUID().toString());
	AccountCode code = AccountCode.create(UUID.randomUUID().toString());
	AccountName name = AccountName.create(UUID.randomUUID().toString());
	AccountStatus status = AccountStatus.create(UUID.randomUUID().toString());
	AccountCurrency currency = AccountCurrency.create(UUID.randomUUID().toString());
	AccountTypeAccount typeAccount = AccountTypeAccount.create(UUID.randomUUID().toString());
	AccountBalance balance = AccountBalance.create(361.13);
	AccountBalancePrev balancePrev = AccountBalancePrev.create(9699.0);
	AccountBalanceBlocked balanceBlocked = AccountBalanceBlocked.create(9145.49);
	AccountBalanceInit balanceInit = AccountBalanceInit.create(9700.32);
	AccountBalanceGoal balanceGoal = AccountBalanceGoal.create(7957.78);
	AccountBalanceLimit balanceLimit = AccountBalanceLimit.create(3724.86);
	AccountDescription description = AccountDescription.create(UUID.randomUUID().toString());
	AccountIsActive isActive = AccountIsActive.create(true);
	AccountIsDefault isDefault = AccountIsDefault.create(true);
	AccountSyncAt syncAt = AccountSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	AccountCreatedBy createdBy = AccountCreatedBy.create(UUID.randomUUID().toString());
	AccountTenant tenant = AccountTenant.create(UUID.randomUUID().toString());
	AccountAggregate aggregateAccountAggregate = new AccountAggregate(id, code, name, status, currency, typeAccount, balance, balancePrev, balanceBlocked, balanceInit, balanceGoal, balanceLimit, description, isActive, isDefault, syncAt, createdBy, tenant);
	assertThat(aggregateAccountAggregate.getId()).isNotNull();
	assertThat(aggregateAccountAggregate.getId()).isEqualTo(id);
	assertThat(aggregateAccountAggregate.getCode()).isEqualTo(code);
	assertThat(aggregateAccountAggregate.getName()).isEqualTo(name);
	assertThat(aggregateAccountAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateAccountAggregate.getCurrency()).isEqualTo(currency);
	assertThat(aggregateAccountAggregate.getTypeAccount()).isEqualTo(typeAccount);
	assertThat(aggregateAccountAggregate.getBalance()).isEqualTo(balance);
	assertThat(aggregateAccountAggregate.getBalancePrev()).isEqualTo(balancePrev);
	assertThat(aggregateAccountAggregate.getBalanceBlocked()).isEqualTo(balanceBlocked);
	assertThat(aggregateAccountAggregate.getBalanceInit()).isEqualTo(balanceInit);
	assertThat(aggregateAccountAggregate.getBalanceGoal()).isEqualTo(balanceGoal);
	assertThat(aggregateAccountAggregate.getBalanceLimit()).isEqualTo(balanceLimit);
	assertThat(aggregateAccountAggregate.getDescription()).isEqualTo(description);
	assertThat(aggregateAccountAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateAccountAggregate.getIsDefault()).isEqualTo(isDefault);
	assertThat(aggregateAccountAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateAccountAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateAccountAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		AccountIdNotValid error = assertThrows(AccountIdNotValid.class, () -> AccountId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_currency_is_invalid() {
		AccountCurrencyNotValid error = assertThrows(AccountCurrencyNotValid.class, () -> AccountCurrency.create(""));
		assertThat(error.getMessage()).isEqualTo("Currency is invalid");
		}
		@Test
		void it_should_throw_when_balance_is_invalid() {
		AccountBalanceNotValid error = assertThrows(AccountBalanceNotValid.class, () -> AccountBalance.create(null));
		assertThat(error.getMessage()).isEqualTo("Balance is invalid");
		}
		@Test
		void it_should_throw_when_balancePrev_is_invalid() {
		AccountBalancePrevNotValid error = assertThrows(AccountBalancePrevNotValid.class, () -> AccountBalancePrev.create(null));
		assertThat(error.getMessage()).isEqualTo("BalancePrev is invalid");
		}
		@Test
		void it_should_throw_when_balanceBlocked_is_invalid() {
		AccountBalanceBlockedNotValid error = assertThrows(AccountBalanceBlockedNotValid.class, () -> AccountBalanceBlocked.create(null));
		assertThat(error.getMessage()).isEqualTo("BalanceBlocked is invalid");
		}
		@Test
		void it_should_throw_when_balanceInit_is_invalid() {
		AccountBalanceInitNotValid error = assertThrows(AccountBalanceInitNotValid.class, () -> AccountBalanceInit.create(null));
		assertThat(error.getMessage()).isEqualTo("BalanceInit is invalid");
		}
		@Test
		void it_should_throw_when_balanceGoal_is_invalid() {
		AccountBalanceGoalNotValid error = assertThrows(AccountBalanceGoalNotValid.class, () -> AccountBalanceGoal.create(null));
		assertThat(error.getMessage()).isEqualTo("BalanceGoal is invalid");
		}
		@Test
		void it_should_throw_when_balanceLimit_is_invalid() {
		AccountBalanceLimitNotValid error = assertThrows(AccountBalanceLimitNotValid.class, () -> AccountBalanceLimit.create(null));
		assertThat(error.getMessage()).isEqualTo("BalanceLimit is invalid");
		}

}
