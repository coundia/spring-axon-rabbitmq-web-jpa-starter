package com.groupe2cs.bizyhub.transactions.domain;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class TransactionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transaction_with_valid_values() {
	TransactionId id = TransactionId.create(UUID.randomUUID().toString());
	TransactionName name = TransactionName.create(UUID.randomUUID().toString());
	TransactionAmount amount = TransactionAmount.create(5539.99);
	TransactionDetails details = TransactionDetails.create(UUID.randomUUID().toString());
	TransactionIsActive isActive = TransactionIsActive.create(true);
	TransactionAccount account = TransactionAccount.create(UUID.randomUUID().toString());
	TransactionCategory category = TransactionCategory.create(UUID.randomUUID().toString());
	TransactionTypeTransactionRaw typeTransactionRaw = TransactionTypeTransactionRaw.create(UUID.randomUUID().toString());
	TransactionDateTransaction dateTransaction = TransactionDateTransaction.create(java.time.Instant.now().plusSeconds(3600));
	TransactionCreatedBy createdBy = TransactionCreatedBy.create(UUID.randomUUID().toString());
	TransactionTenant tenant = TransactionTenant.create(UUID.randomUUID().toString());
	TransactionAggregate aggregateTransactionAggregate = new TransactionAggregate(id, name, amount, details, isActive, account, category, typeTransactionRaw, dateTransaction, createdBy, tenant);
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
		void it_should_throw_when_isActive_is_invalid() {
		TransactionIsActiveNotValid error = assertThrows(TransactionIsActiveNotValid.class, () -> TransactionIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}

}
