package com.groupe2cs.bizyhub.accounts.domain;

import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIdNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserIsActiveNotValid;
import com.groupe2cs.bizyhub.accounts.domain.exception.AccountUserNameNotValid;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountUserAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_accountUser_with_valid_values() {
		AccountUserId id = AccountUserId.create(UUID.randomUUID().toString());
		AccountUserName name = AccountUserName.create(UUID.randomUUID().toString());
		AccountUserAccount account = AccountUserAccount.create(UUID.randomUUID().toString());
		AccountUserUser user = AccountUserUser.create(UUID.randomUUID().toString());
		AccountUserUsername username = AccountUserUsername.create(UUID.randomUUID().toString());
		AccountUserDetails details = AccountUserDetails.create(UUID.randomUUID().toString());
		AccountUserIsActive isActive = AccountUserIsActive.create(true);
		AccountUserCreatedBy createdBy = AccountUserCreatedBy.create(UUID.randomUUID().toString());
		AccountUserTenant tenant = AccountUserTenant.create(UUID.randomUUID().toString());
		AccountUserAggregate
				aggregateAccountUserAggregate =
				new AccountUserAggregate(id, name, account, user, username, details, isActive, createdBy, tenant);
		assertThat(aggregateAccountUserAggregate.getId()).isNotNull();
		assertThat(aggregateAccountUserAggregate.getId()).isEqualTo(id);
		assertThat(aggregateAccountUserAggregate.getName()).isEqualTo(name);
		assertThat(aggregateAccountUserAggregate.getAccount()).isEqualTo(account);
		assertThat(aggregateAccountUserAggregate.getUser()).isEqualTo(user);
		assertThat(aggregateAccountUserAggregate.getUsername()).isEqualTo(username);
		assertThat(aggregateAccountUserAggregate.getDetails()).isEqualTo(details);
		assertThat(aggregateAccountUserAggregate.getIsActive()).isEqualTo(isActive);
		assertThat(aggregateAccountUserAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateAccountUserAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		AccountUserIdNotValid error = assertThrows(AccountUserIdNotValid.class, () -> AccountUserId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_name_is_invalid() {
		AccountUserNameNotValid error = assertThrows(AccountUserNameNotValid.class, () -> AccountUserName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
	}

	@Test
	void it_should_throw_when_isActive_is_invalid() {
		AccountUserIsActiveNotValid
				error =
				assertThrows(AccountUserIsActiveNotValid.class, () -> AccountUserIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
	}

}
