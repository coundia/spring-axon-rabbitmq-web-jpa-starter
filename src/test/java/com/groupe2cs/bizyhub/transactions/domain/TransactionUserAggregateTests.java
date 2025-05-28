package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;


public class TransactionUserAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transactionUser_with_valid_values() {
	TransactionUserId id = TransactionUserId.create(UUID.randomUUID().toString());
	TransactionUserName name = TransactionUserName.create(UUID.randomUUID().toString());
	TransactionUserTransaction transaction = TransactionUserTransaction.create(UUID.randomUUID().toString());
	TransactionUserUser user = TransactionUserUser.create(UUID.randomUUID().toString());
	TransactionUserUsername username = TransactionUserUsername.create(UUID.randomUUID().toString());
	TransactionUserDetails details = TransactionUserDetails.create(UUID.randomUUID().toString());
	TransactionUserIsActive isActive = TransactionUserIsActive.create(true);
	TransactionUserCreatedBy createdBy = TransactionUserCreatedBy.create(UUID.randomUUID().toString());
	TransactionUserTenant tenant = TransactionUserTenant.create(UUID.randomUUID().toString());
	TransactionUserAggregate aggregateTransactionUserAggregate = new TransactionUserAggregate(id, name, transaction, user, username, details, isActive, createdBy, tenant);
	assertThat(aggregateTransactionUserAggregate.getId()).isNotNull();
	assertThat(aggregateTransactionUserAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTransactionUserAggregate.getName()).isEqualTo(name);
	assertThat(aggregateTransactionUserAggregate.getTransaction()).isEqualTo(transaction);
	assertThat(aggregateTransactionUserAggregate.getUser()).isEqualTo(user);
	assertThat(aggregateTransactionUserAggregate.getUsername()).isEqualTo(username);
	assertThat(aggregateTransactionUserAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateTransactionUserAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateTransactionUserAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateTransactionUserAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		TransactionUserIdNotValid error = assertThrows(TransactionUserIdNotValid.class, () -> TransactionUserId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		TransactionUserNameNotValid error = assertThrows(TransactionUserNameNotValid.class, () -> TransactionUserName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		TransactionUserIsActiveNotValid error = assertThrows(TransactionUserIsActiveNotValid.class, () -> TransactionUserIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}

}
