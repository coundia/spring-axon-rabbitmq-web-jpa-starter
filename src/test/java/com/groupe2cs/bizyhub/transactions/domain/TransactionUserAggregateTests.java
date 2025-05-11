package com.groupe2cs.bizyhub.transactions.domain;

import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
	TransactionUserUpdatedAt updatedAt = TransactionUserUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	TransactionUserReference reference = TransactionUserReference.create(UUID.randomUUID().toString());
	TransactionUserCreatedBy createdBy = TransactionUserCreatedBy.create(UUID.randomUUID().toString());
	TransactionUserTenant tenant = TransactionUserTenant.create(UUID.randomUUID().toString());
	TransactionUserAggregate aggregateTransactionUserAggregate = new TransactionUserAggregate(id, name, transaction, user, username, details, isActive, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateTransactionUserAggregate.getId()).isNotNull();
	assertThat(aggregateTransactionUserAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTransactionUserAggregate.getName()).isEqualTo(name);
	assertThat(aggregateTransactionUserAggregate.getTransaction()).isEqualTo(transaction);
	assertThat(aggregateTransactionUserAggregate.getUser()).isEqualTo(user);
	assertThat(aggregateTransactionUserAggregate.getUsername()).isEqualTo(username);
	assertThat(aggregateTransactionUserAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateTransactionUserAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateTransactionUserAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateTransactionUserAggregate.getReference()).isEqualTo(reference);
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
		void it_should_throw_when_transaction_is_invalid() {
		TransactionUserTransactionNotValid error = assertThrows(TransactionUserTransactionNotValid.class, () -> TransactionUserTransaction.create(""));
		assertThat(error.getMessage()).isEqualTo("Transaction is invalid");
		}
		@Test
		void it_should_throw_when_user_is_invalid() {
		TransactionUserUserNotValid error = assertThrows(TransactionUserUserNotValid.class, () -> TransactionUserUser.create(""));
		assertThat(error.getMessage()).isEqualTo("User is invalid");
		}
		@Test
		void it_should_throw_when_username_is_invalid() {
		TransactionUserUsernameNotValid error = assertThrows(TransactionUserUsernameNotValid.class, () -> TransactionUserUsername.create(""));
		assertThat(error.getMessage()).isEqualTo("Username is invalid");
		}
		@Test
		void it_should_throw_when_details_is_invalid() {
		TransactionUserDetailsNotValid error = assertThrows(TransactionUserDetailsNotValid.class, () -> TransactionUserDetails.create(""));
		assertThat(error.getMessage()).isEqualTo("Details is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		TransactionUserIsActiveNotValid error = assertThrows(TransactionUserIsActiveNotValid.class, () -> TransactionUserIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		TransactionUserUpdatedAtNotValid error = assertThrows(TransactionUserUpdatedAtNotValid.class, () -> TransactionUserUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		TransactionUserReferenceNotValid error = assertThrows(TransactionUserReferenceNotValid.class, () -> TransactionUserReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		TransactionUserCreatedByNotValid error = assertThrows(TransactionUserCreatedByNotValid.class, () -> TransactionUserCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		TransactionUserTenantNotValid error = assertThrows(TransactionUserTenantNotValid.class, () -> TransactionUserTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
