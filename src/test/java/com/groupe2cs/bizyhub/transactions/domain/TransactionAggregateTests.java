package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


public class TransactionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transaction_with_valid_values() {
	TransactionId id = TransactionId.create(UUID.randomUUID().toString());
	TransactionRemoteId remoteId = TransactionRemoteId.create(UUID.randomUUID().toString());
	TransactionLocalId localId = TransactionLocalId.create(UUID.randomUUID().toString());
	TransactionCode code = TransactionCode.create(UUID.randomUUID().toString());
	TransactionDescription description = TransactionDescription.create(UUID.randomUUID().toString());
	TransactionAmount amount = TransactionAmount.create(4463.15);
	TransactionTypeEntry typeEntry = TransactionTypeEntry.create(UUID.randomUUID().toString());
	TransactionDateTransaction dateTransaction = TransactionDateTransaction.create(java.time.Instant.now().plusSeconds(3600));
	TransactionStatus status = TransactionStatus.create(UUID.randomUUID().toString());
	TransactionEntityName entityName = TransactionEntityName.create(UUID.randomUUID().toString());
	TransactionEntityId entityId = TransactionEntityId.create(UUID.randomUUID().toString());
	TransactionAccount account = TransactionAccount.create(UUID.randomUUID().toString());
	TransactionSyncAt syncAt = TransactionSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	TransactionCategory category = TransactionCategory.create(UUID.randomUUID().toString());
	TransactionCompany company = TransactionCompany.create(UUID.randomUUID().toString());
	TransactionCustomer customer = TransactionCustomer.create(UUID.randomUUID().toString());
	TransactionDebt debt = TransactionDebt.create(UUID.randomUUID().toString());
	TransactionCreatedBy createdBy = TransactionCreatedBy.create(UUID.randomUUID().toString());
	TransactionTenant tenant = TransactionTenant.create(UUID.randomUUID().toString());
	TransactionAggregate aggregateTransactionAggregate = new TransactionAggregate(id, remoteId, localId, code, description, amount, typeEntry, dateTransaction, status, entityName, entityId, account, syncAt, category, company, customer, debt, createdBy, tenant);
	assertThat(aggregateTransactionAggregate.getId()).isNotNull();
	assertThat(aggregateTransactionAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTransactionAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateTransactionAggregate.getLocalId()).isEqualTo(localId);
	assertThat(aggregateTransactionAggregate.getCode()).isEqualTo(code);
	assertThat(aggregateTransactionAggregate.getDescription()).isEqualTo(description);
	assertThat(aggregateTransactionAggregate.getAmount()).isEqualTo(amount);
	assertThat(aggregateTransactionAggregate.getTypeEntry()).isEqualTo(typeEntry);
	assertThat(aggregateTransactionAggregate.getDateTransaction()).isEqualTo(dateTransaction);
	assertThat(aggregateTransactionAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateTransactionAggregate.getEntityName()).isEqualTo(entityName);
	assertThat(aggregateTransactionAggregate.getEntityId()).isEqualTo(entityId);
	assertThat(aggregateTransactionAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateTransactionAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateTransactionAggregate.getCategory()).isEqualTo(category);
	assertThat(aggregateTransactionAggregate.getCompany()).isEqualTo(company);
	assertThat(aggregateTransactionAggregate.getCustomer()).isEqualTo(customer);
	assertThat(aggregateTransactionAggregate.getDebt()).isEqualTo(debt);
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
		void it_should_throw_when_typeEntry_is_invalid() {
		TransactionTypeEntryNotValid error = assertThrows(TransactionTypeEntryNotValid.class, () -> TransactionTypeEntry.create(""));
		assertThat(error.getMessage()).isEqualTo("TypeEntry is invalid");
		}

}
