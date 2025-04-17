package com.groupe2cs.bizyhub.transactions.domain;

import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TransactionsAggregateTests extends BaseUnitTests {

@Test
void it_should_create_transactions_with_valid_values() {
	TransactionsId id = TransactionsId.create(UUID.randomUUID().toString());
	TransactionsReference reference = TransactionsReference.create(UUID.randomUUID().toString());
	TransactionsAmount amount = TransactionsAmount.create(9013.6);
	TransactionsAggregate transactions = new TransactionsAggregate(id, reference, amount);
	assertThat(transactions.getId()).isNotNull();
	assertThat(transactions.getId()).isEqualTo(id);
	assertThat(transactions.getReference()).isEqualTo(reference);
	assertThat(transactions.getAmount()).isEqualTo(amount);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		TransactionsIdNotValid error = assertThrows(TransactionsIdNotValid.class, () -> TransactionsId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		TransactionsReferenceNotValid error = assertThrows(TransactionsReferenceNotValid.class, () -> TransactionsReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_amount_is_invalid() {
		TransactionsAmountNotValid error = assertThrows(TransactionsAmountNotValid.class, () -> TransactionsAmount.create(null));
		assertThat(error.getMessage()).isEqualTo("Amount is invalid");
		}

}
