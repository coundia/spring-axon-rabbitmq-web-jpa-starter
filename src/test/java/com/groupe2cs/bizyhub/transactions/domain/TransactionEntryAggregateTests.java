package com.groupe2cs.bizyhub.transactions.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;


public class TransactionEntryAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transactionEntry_with_valid_values() {
	TransactionEntryId id = TransactionEntryId.create(UUID.randomUUID().toString());
	TransactionEntryRemoteId remoteId = TransactionEntryRemoteId.create(UUID.randomUUID().toString());
	TransactionEntryCode code = TransactionEntryCode.create(UUID.randomUUID().toString());
	TransactionEntryDescription description = TransactionEntryDescription.create(UUID.randomUUID().toString());
	TransactionEntryAmount amount = TransactionEntryAmount.create(5410.48);
	TransactionEntryTypeEntry typeEntry = TransactionEntryTypeEntry.create(UUID.randomUUID().toString());
	TransactionEntryDateTransaction dateTransaction = TransactionEntryDateTransaction.create(java.time.Instant.now().plusSeconds(3600));
	TransactionEntryStatus status = TransactionEntryStatus.create(UUID.randomUUID().toString());
	TransactionEntryEntityName entityName = TransactionEntryEntityName.create(UUID.randomUUID().toString());
	TransactionEntryEntityId entityId = TransactionEntryEntityId.create(UUID.randomUUID().toString());
	TransactionEntryAccount account = TransactionEntryAccount.create(UUID.randomUUID().toString());
	TransactionEntrySyncAt syncAt = TransactionEntrySyncAt.create(java.time.Instant.now().plusSeconds(3600));
	TransactionEntryCategory category = TransactionEntryCategory.create(UUID.randomUUID().toString());
	TransactionEntryCompany company = TransactionEntryCompany.create(UUID.randomUUID().toString());
	TransactionEntryCustomer customer = TransactionEntryCustomer.create(UUID.randomUUID().toString());
	TransactionEntryDebt debt = TransactionEntryDebt.create(UUID.randomUUID().toString());
	TransactionEntryCreatedBy createdBy = TransactionEntryCreatedBy.create(UUID.randomUUID().toString());
	TransactionEntryTenant tenant = TransactionEntryTenant.create(UUID.randomUUID().toString());
	TransactionEntryAggregate aggregateTransactionEntryAggregate = new TransactionEntryAggregate(id, remoteId, code, description, amount, typeEntry, dateTransaction, status, entityName, entityId, account, syncAt, category, company, customer, debt, createdBy, tenant);
	assertThat(aggregateTransactionEntryAggregate.getId()).isNotNull();
	assertThat(aggregateTransactionEntryAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTransactionEntryAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateTransactionEntryAggregate.getCode()).isEqualTo(code);
	assertThat(aggregateTransactionEntryAggregate.getDescription()).isEqualTo(description);
	assertThat(aggregateTransactionEntryAggregate.getAmount()).isEqualTo(amount);
	assertThat(aggregateTransactionEntryAggregate.getTypeEntry()).isEqualTo(typeEntry);
	assertThat(aggregateTransactionEntryAggregate.getDateTransaction()).isEqualTo(dateTransaction);
	assertThat(aggregateTransactionEntryAggregate.getStatus()).isEqualTo(status);
	assertThat(aggregateTransactionEntryAggregate.getEntityName()).isEqualTo(entityName);
	assertThat(aggregateTransactionEntryAggregate.getEntityId()).isEqualTo(entityId);
	assertThat(aggregateTransactionEntryAggregate.getAccount()).isEqualTo(account);
	assertThat(aggregateTransactionEntryAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateTransactionEntryAggregate.getCategory()).isEqualTo(category);
	assertThat(aggregateTransactionEntryAggregate.getCompany()).isEqualTo(company);
	assertThat(aggregateTransactionEntryAggregate.getCustomer()).isEqualTo(customer);
	assertThat(aggregateTransactionEntryAggregate.getDebt()).isEqualTo(debt);
	assertThat(aggregateTransactionEntryAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateTransactionEntryAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		TransactionEntryIdNotValid error = assertThrows(TransactionEntryIdNotValid.class, () -> TransactionEntryId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_amount_is_invalid() {
		TransactionEntryAmountNotValid error = assertThrows(TransactionEntryAmountNotValid.class, () -> TransactionEntryAmount.create(null));
		assertThat(error.getMessage()).isEqualTo("Amount is invalid");
		}
		@Test
		void it_should_throw_when_typeEntry_is_invalid() {
		TransactionEntryTypeEntryNotValid error = assertThrows(TransactionEntryTypeEntryNotValid.class, () -> TransactionEntryTypeEntry.create(""));
		assertThat(error.getMessage()).isEqualTo("TypeEntry is invalid");
		}

}
