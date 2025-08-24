package com.groupe2cs.bizyhub.transactions.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;


public class TransactionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transaction_with_valid_values() {
	TransactionId id = TransactionId.create(UUID.randomUUID().toString());
	TransactionName name = TransactionName.create(UUID.randomUUID().toString());
	TransactionAmount amount = TransactionAmount.create(2298.93);
	TransactionRemoteId remoteId = TransactionRemoteId.create(UUID.randomUUID().toString());
	TransactionDetails details = TransactionDetails.create(UUID.randomUUID().toString());
	TransactionIsActive isActive = TransactionIsActive.create(false);
	TransactionSyncAt syncAt = TransactionSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	TransactionAccount account = TransactionAccount.create(UUID.randomUUID().toString());
	TransactionCategory category = TransactionCategory.create(UUID.randomUUID().toString());
	TransactionTypeEntry typeEntry = TransactionTypeEntry.create(UUID.randomUUID().toString());
	TransactionTypeTransactionRaw typeTransactionRaw = TransactionTypeTransactionRaw.create(UUID.randomUUID().toString());
	TransactionDateTransaction dateTransaction = TransactionDateTransaction.create(java.time.Instant.now().plusSeconds(3600));
	TransactionCreatedBy createdBy = TransactionCreatedBy.create(UUID.randomUUID().toString());
	TransactionTenant tenant = TransactionTenant.create(UUID.randomUUID().toString());
	TransactionAggregate aggregateTransactionAggregate = new TransactionAggregate(id, name, amount, remoteId, details, isActive, syncAt, account, category, typeEntry, typeTransactionRaw, dateTransaction, createdBy, tenant);
	assertThat(aggregateTransactionAggregate.getId()).isNotNull();
	assertThat(aggregateTransactionAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTransactionAggregate.getName()).isEqualTo(name);
	assertThat(aggregateTransactionAggregate.getAmount()).isEqualTo(amount);
	assertThat(aggregateTransactionAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateTransactionAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateTransactionAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateTransactionAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateTransactionAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateTransactionAggregate.getCategory()).isEqualTo(category);
	assertThat(aggregateTransactionAggregate.getTypeEntry()).isEqualTo(typeEntry);
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

}
