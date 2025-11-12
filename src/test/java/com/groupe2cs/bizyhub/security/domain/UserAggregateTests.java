package com.groupe2cs.bizyhub.security.domain;

import com.groupe2cs.bizyhub.security.domain.exception.UserIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserPasswordNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.UserUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_user_with_valid_values() {
		UserId id = UserId.create(UUID.randomUUID().toString());
		UserUsername username = UserUsername.create(UUID.randomUUID().toString());
		UserPassword password = UserPassword.create(UUID.randomUUID().toString());
		UserFirstName firstName = UserFirstName.create(UUID.randomUUID().toString());
		UserLastName lastName = UserLastName.create(UUID.randomUUID().toString());
		UserEmail email = UserEmail.create(UUID.randomUUID().toString());
		UserTelephone telephone = UserTelephone.create(UUID.randomUUID().toString());
		UserLimitPerDay limitPerDay = UserLimitPerDay.create(74);
		UserIsPremium isPremium = UserIsPremium.create(true);
		UserEnabled enabled = UserEnabled.create(true);
		UserIsBan isBan = UserIsBan.create(false);
		UserMessage message = UserMessage.create(UUID.randomUUID().toString());
		UserCreatedBy createdBy = UserCreatedBy.create(UUID.randomUUID().toString());
		UserTenant tenant = UserTenant.create(UUID.randomUUID().toString());
		UserAggregate
				aggregateUserAggregate =
				new UserAggregate(id,
						username,
						password,
						firstName,
						lastName,
						email,
						telephone,
						limitPerDay,
						isPremium,
						enabled,
						isBan,
						message,
						createdBy,
						tenant);
		assertThat(aggregateUserAggregate.getId()).isNotNull();
		assertThat(aggregateUserAggregate.getId()).isEqualTo(id);
		assertThat(aggregateUserAggregate.getUsername()).isEqualTo(username);
		assertThat(aggregateUserAggregate.getPassword()).isEqualTo(password);
		assertThat(aggregateUserAggregate.getFirstName()).isEqualTo(firstName);
		assertThat(aggregateUserAggregate.getLastName()).isEqualTo(lastName);
		assertThat(aggregateUserAggregate.getEmail()).isEqualTo(email);
		assertThat(aggregateUserAggregate.getTelephone()).isEqualTo(telephone);
		assertThat(aggregateUserAggregate.getLimitPerDay()).isEqualTo(limitPerDay);
		assertThat(aggregateUserAggregate.getIsPremium()).isEqualTo(isPremium);
		assertThat(aggregateUserAggregate.getEnabled()).isEqualTo(enabled);
		assertThat(aggregateUserAggregate.getIsBan()).isEqualTo(isBan);
		assertThat(aggregateUserAggregate.getMessage()).isEqualTo(message);
		assertThat(aggregateUserAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateUserAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		UserIdNotValid error = assertThrows(UserIdNotValid.class, () -> UserId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_username_is_invalid() {
		UserUsernameNotValid error = assertThrows(UserUsernameNotValid.class, () -> UserUsername.create(""));
		assertThat(error.getMessage()).isEqualTo("Username is invalid");
	}

	@Test
	void it_should_throw_when_password_is_invalid() {
		UserPasswordNotValid error = assertThrows(UserPasswordNotValid.class, () -> UserPassword.create(""));
		assertThat(error.getMessage()).isEqualTo("Password is invalid");
	}

}
