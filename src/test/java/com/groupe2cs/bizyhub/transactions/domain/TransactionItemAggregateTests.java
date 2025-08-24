package com.groupe2cs.bizyhub.transactions.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;


public class TransactionItemAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transactionItem_with_valid_values() {
	TransactionItemId id = TransactionItemId.create(UUID.randomUUID().toString());
	TransactionItemTransaction transaction = TransactionItemTransaction.create(UUID.randomUUID().toString());
	TransactionItemProduct product = TransactionItemProduct.create(UUID.randomUUID().toString());
	TransactionItemLabel label = TransactionItemLabel.create(UUID.randomUUID().toString());
	TransactionItemQuantity quantity = TransactionItemQuantity.create(80);
	TransactionItemUnit unit = TransactionItemUnit.create(UUID.randomUUID().toString());
	TransactionItemRemoteId remoteId = TransactionItemRemoteId.create(UUID.randomUUID().toString());
	TransactionItemSyncAt syncAt = TransactionItemSyncAt.create(java.time.Instant.now().plusSeconds(3600));
	TransactionItemUnitPrice unitPrice = TransactionItemUnitPrice.create(2885.39);
	TransactionItemTotal total = TransactionItemTotal.create(8035.23);
	TransactionItemNotes notes = TransactionItemNotes.create(UUID.randomUUID().toString());
	TransactionItemCreatedBy createdBy = TransactionItemCreatedBy.create(UUID.randomUUID().toString());
	TransactionItemTenant tenant = TransactionItemTenant.create(UUID.randomUUID().toString());
	TransactionItemAggregate aggregateTransactionItemAggregate = new TransactionItemAggregate(id, transaction, product, label, quantity, unit, remoteId, syncAt, unitPrice, total, notes, createdBy, tenant);
	assertThat(aggregateTransactionItemAggregate.getId()).isNotNull();
	assertThat(aggregateTransactionItemAggregate.getId()).isEqualTo(id);
	assertThat(aggregateTransactionItemAggregate.getTransaction()).isEqualTo(transaction);
	assertThat(aggregateTransactionItemAggregate.getProduct()).isEqualTo(product);
	assertThat(aggregateTransactionItemAggregate.getLabel()).isEqualTo(label);
	assertThat(aggregateTransactionItemAggregate.getQuantity()).isEqualTo(quantity);
	assertThat(aggregateTransactionItemAggregate.getUnit()).isEqualTo(unit);
	assertThat(aggregateTransactionItemAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateTransactionItemAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateTransactionItemAggregate.getUnitPrice()).isEqualTo(unitPrice);
	assertThat(aggregateTransactionItemAggregate.getTotal()).isEqualTo(total);
	assertThat(aggregateTransactionItemAggregate.getNotes()).isEqualTo(notes);
	assertThat(aggregateTransactionItemAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateTransactionItemAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		TransactionItemIdNotValid error = assertThrows(TransactionItemIdNotValid.class, () -> TransactionItemId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_transaction_is_invalid() {
		TransactionItemTransactionNotValid error = assertThrows(TransactionItemTransactionNotValid.class, () -> TransactionItemTransaction.create(""));
		assertThat(error.getMessage()).isEqualTo("Transaction is invalid");
		}
		@Test
		void it_should_throw_when_quantity_is_invalid() {
		TransactionItemQuantityNotValid error = assertThrows(TransactionItemQuantityNotValid.class, () -> TransactionItemQuantity.create(-1));
		assertThat(error.getMessage()).isEqualTo("Quantity is invalid");
		}
		@Test
		void it_should_throw_when_unitPrice_is_invalid() {
		TransactionItemUnitPriceNotValid error = assertThrows(TransactionItemUnitPriceNotValid.class, () -> TransactionItemUnitPrice.create(null));
		assertThat(error.getMessage()).isEqualTo("UnitPrice is invalid");
		}
		@Test
		void it_should_throw_when_total_is_invalid() {
		TransactionItemTotalNotValid error = assertThrows(TransactionItemTotalNotValid.class, () -> TransactionItemTotal.create(null));
		assertThat(error.getMessage()).isEqualTo("Total is invalid");
		}

}
