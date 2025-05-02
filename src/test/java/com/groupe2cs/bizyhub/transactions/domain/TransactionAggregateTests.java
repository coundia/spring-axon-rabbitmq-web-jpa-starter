package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;


public class TransactionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transaction_with_valid_values() {
	TransactionId id = TransactionId.create(UUID.randomUUID().toString());
	TransactionAmount amount = TransactionAmount.create(6798.69);
	TransactionDateOperation dateOperation = TransactionDateOperation.create(java.time.Instant.now().plusSeconds(3600));
	TransactionDescription description = TransactionDescription.create(UUID.randomUUID().toString());
	TransactionReference reference = TransactionReference.create(UUID.randomUUID().toString());
	TransactionIsRecurring isRecurring = TransactionIsRecurring.create(true);
	TransactionIsExcluToRapport isExcluToRapport = TransactionIsExcluToRapport.create(true);
	TransactionStatus status = TransactionStatus.create(UUID.randomUUID().toString());
	TransactionBalance balance = TransactionBalance.create(UUID.randomUUID().toString());
	TransactionCategory category = TransactionCategory.create(UUID.randomUUID().toString());
	TransactionUpdatedAt updatedAt = TransactionUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	TransactionCreatedAt createdAt = TransactionCreatedAt.create(java.time.Instant.now().plusSeconds(3600));
	TransactionCreatedBy createdBy = TransactionCreatedBy.create(UUID.randomUUID().toString());
	TransactionTenant tenant = TransactionTenant.create(UUID.randomUUID().toString());
	TransactionAggregate aggregateTransactionAggregate = new TransactionAggregate(id, amount, dateOperation, description, reference, isRecurring, isExcluToRapport, status, balance, category, updatedAt, createdAt, createdBy, tenant);
	assertThat(aggregateTransactionAggregate.getId()).isNotNull();
	assertThat(aggregateTransactionAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTransactionAggregate.getAmount()).isEqualTo(amount);
	assertThat(aggregateTransactionAggregate.getDateOperation()).isEqualTo(dateOperation);
	assertThat(aggregateTransactionAggregate.getDescription()).isEqualTo(description);
	assertThat(aggregateTransactionAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateTransactionAggregate.getIsRecurring()).isEqualTo(isRecurring);
	assertThat(aggregateTransactionAggregate.getIsExcluToRapport()).isEqualTo(isExcluToRapport);
	assertThat(aggregateTransactionAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateTransactionAggregate.getBalance()).isEqualTo(balance);
	assertThat(aggregateTransactionAggregate.getCategory()).isEqualTo(category);
	assertThat(aggregateTransactionAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateTransactionAggregate.getCreatedAt()).isEqualTo(createdAt);
	assertThat(aggregateTransactionAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateTransactionAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		TransactionIdNotValid error = assertThrows(TransactionIdNotValid.class, () -> TransactionId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_amount_is_invalid() {
		TransactionAmountNotValid error = assertThrows(TransactionAmountNotValid.class, () -> TransactionAmount.create(null));
		assertThat(error.getMessage()).isEqualTo("Amount is invalid");
		}
		@Test
		void it_should_throw_when_dateOperation_is_invalid() {
		TransactionDateOperationNotValid error = assertThrows(TransactionDateOperationNotValid.class, () -> TransactionDateOperation.create(null));
		assertThat(error.getMessage()).isEqualTo("DateOperation is invalid");
		}
		@Test
		void it_should_throw_when_description_is_invalid() {
		TransactionDescriptionNotValid error = assertThrows(TransactionDescriptionNotValid.class, () -> TransactionDescription.create(""));
		assertThat(error.getMessage()).isEqualTo("Description is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		TransactionReferenceNotValid error = assertThrows(TransactionReferenceNotValid.class, () -> TransactionReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_isRecurring_is_invalid() {
		TransactionIsRecurringNotValid error = assertThrows(TransactionIsRecurringNotValid.class, () -> TransactionIsRecurring.create(null));
		assertThat(error.getMessage()).isEqualTo("IsRecurring is invalid");
		}
		@Test
		void it_should_throw_when_isExcluToRapport_is_invalid() {
		TransactionIsExcluToRapportNotValid error = assertThrows(TransactionIsExcluToRapportNotValid.class, () -> TransactionIsExcluToRapport.create(null));
		assertThat(error.getMessage()).isEqualTo("IsExcluToRapport is invalid");
		}
		@Test
		void it_should_throw_when_status_is_invalid() {
		TransactionStatusNotValid error = assertThrows(TransactionStatusNotValid.class, () -> TransactionStatus.create(""));
		assertThat(error.getMessage()).isEqualTo("Status is invalid");
		}
		@Test
		void it_should_throw_when_balance_is_invalid() {
		TransactionBalanceNotValid error = assertThrows(TransactionBalanceNotValid.class, () -> TransactionBalance.create(""));
		assertThat(error.getMessage()).isEqualTo("Balance is invalid");
		}
		@Test
		void it_should_throw_when_category_is_invalid() {
		TransactionCategoryNotValid error = assertThrows(TransactionCategoryNotValid.class, () -> TransactionCategory.create(""));
		assertThat(error.getMessage()).isEqualTo("Category is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		TransactionUpdatedAtNotValid error = assertThrows(TransactionUpdatedAtNotValid.class, () -> TransactionUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_createdAt_is_invalid() {
		TransactionCreatedAtNotValid error = assertThrows(TransactionCreatedAtNotValid.class, () -> TransactionCreatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("CreatedAt is invalid");
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
