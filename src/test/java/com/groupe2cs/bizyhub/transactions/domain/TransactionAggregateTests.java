package com.groupe2cs.bizyhub.transactions.domain;

import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TransactionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transaction_with_valid_values() {
	TransactionId id = TransactionId.create(UUID.randomUUID().toString());
	TransactionName name = TransactionName.create(UUID.randomUUID().toString());
	TransactionAmount amount = TransactionAmount.create(1780.28);
	TransactionDetails details = TransactionDetails.create(UUID.randomUUID().toString());
	TransactionIsActive isActive = TransactionIsActive.create(false);
	TransactionAccount account = TransactionAccount.create(UUID.randomUUID().toString());
	TransactionCategory category = TransactionCategory.create(UUID.randomUUID().toString());
	TransactionTypeTransactionRaw typeTransactionRaw = TransactionTypeTransactionRaw.create(UUID.randomUUID().toString());
	TransactionDateTransaction dateTransaction = TransactionDateTransaction.create(java.time.Instant.now().plusSeconds(3600));
	TransactionUpdatedAt updatedAt = TransactionUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	TransactionReference reference = TransactionReference.create(UUID.randomUUID().toString());
	TransactionCreatedBy createdBy = TransactionCreatedBy.create(UUID.randomUUID().toString());
	TransactionTenant tenant = TransactionTenant.create(UUID.randomUUID().toString());
	TransactionAggregate aggregateTransactionAggregate = new TransactionAggregate(id, name, amount, details, isActive, account, category, typeTransactionRaw, dateTransaction, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateTransactionAggregate.getId()).isNotNull();
	assertThat(aggregateTransactionAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTransactionAggregate.getName()).isEqualTo(name);
	assertThat(aggregateTransactionAggregate.getAmount()).isEqualTo(amount);
	assertThat(aggregateTransactionAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateTransactionAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateTransactionAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateTransactionAggregate.getCategory()).isEqualTo(category);
	assertThat(aggregateTransactionAggregate.getTypeTransactionRaw()).isEqualTo(typeTransactionRaw);
	assertThat(aggregateTransactionAggregate.getDateTransaction()).isEqualTo(dateTransaction);
	assertThat(aggregateTransactionAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateTransactionAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateTransactionAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateTransactionAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		TransactionIdNotValid error = assertThrows(TransactionIdNotValid.class, () -> TransactionId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		TransactionNameNotValid error = assertThrows(TransactionNameNotValid.class, () -> TransactionName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_amount_is_invalid() {
		TransactionAmountNotValid error = assertThrows(TransactionAmountNotValid.class, () -> TransactionAmount.create(null));
		assertThat(error.getMessage()).isEqualTo("Amount is invalid");
		}
		@Test
		void it_should_throw_when_details_is_invalid() {
		TransactionDetailsNotValid error = assertThrows(TransactionDetailsNotValid.class, () -> TransactionDetails.create(""));
		assertThat(error.getMessage()).isEqualTo("Details is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		TransactionIsActiveNotValid error = assertThrows(TransactionIsActiveNotValid.class, () -> TransactionIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}
		@Test
		void it_should_throw_when_account_is_invalid() {
		TransactionAccountNotValid error = assertThrows(TransactionAccountNotValid.class, () -> TransactionAccount.create(""));
		assertThat(error.getMessage()).isEqualTo("Account is invalid");
		}
		@Test
		void it_should_throw_when_category_is_invalid() {
		TransactionCategoryNotValid error = assertThrows(TransactionCategoryNotValid.class, () -> TransactionCategory.create(""));
		assertThat(error.getMessage()).isEqualTo("Category is invalid");
		}
		@Test
		void it_should_throw_when_typeTransactionRaw_is_invalid() {
		TransactionTypeTransactionRawNotValid error = assertThrows(TransactionTypeTransactionRawNotValid.class, () -> TransactionTypeTransactionRaw.create(""));
		assertThat(error.getMessage()).isEqualTo("TypeTransactionRaw is invalid");
		}
		@Test
		void it_should_throw_when_dateTransaction_is_invalid() {
		TransactionDateTransactionNotValid error = assertThrows(TransactionDateTransactionNotValid.class, () -> TransactionDateTransaction.create(null));
		assertThat(error.getMessage()).isEqualTo("DateTransaction is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		TransactionUpdatedAtNotValid error = assertThrows(TransactionUpdatedAtNotValid.class, () -> TransactionUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		TransactionReferenceNotValid error = assertThrows(TransactionReferenceNotValid.class, () -> TransactionReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		TransactionCreatedByNotValid error = assertThrows(TransactionCreatedByNotValid.class, () -> TransactionCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		TransactionTenantNotValid error = assertThrows(TransactionTenantNotValid.class, () -> TransactionTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
