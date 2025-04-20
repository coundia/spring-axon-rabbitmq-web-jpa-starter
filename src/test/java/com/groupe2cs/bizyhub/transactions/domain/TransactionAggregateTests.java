package com.groupe2cs.bizyhub.transactions.domain;

import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;


public class TransactionAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transaction_with_valid_values() {
	TransactionId id = TransactionId.create(UUID.randomUUID().toString());
	TransactionReference reference = TransactionReference.create(UUID.randomUUID().toString());
	TransactionAmount amount = TransactionAmount.create(325.58);
	TransactionAggregate transaction = new TransactionAggregate(id, reference, amount);
	assertThat(transaction.getId()).isNotNull();
	assertThat(transaction.getId()).isEqualTo(id);
	assertThat(transaction.getReference()).isEqualTo(reference);
	assertThat(transaction.getAmount()).isEqualTo(amount);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		TransactionIdNotValid error = assertThrows(TransactionIdNotValid.class, () -> TransactionId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		TransactionReferenceNotValid error = assertThrows(TransactionReferenceNotValid.class, () -> TransactionReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_amount_is_invalid() {
		TransactionAmountNotValid error = assertThrows(TransactionAmountNotValid.class, () -> TransactionAmount.create(null));
		assertThat(error.getMessage()).isEqualTo("Amount is invalid");
		}

}
