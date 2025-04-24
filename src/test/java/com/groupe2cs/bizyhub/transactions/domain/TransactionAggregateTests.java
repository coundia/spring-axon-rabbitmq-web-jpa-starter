package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCreatedByNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionReferenceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionAmount;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionCreatedBy;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionReference;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TransactionAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_transaction_with_valid_values() {
		TransactionId id = TransactionId.create(UUID.randomUUID().toString());
		TransactionReference reference = TransactionReference.create(UUID.randomUUID().toString());
		TransactionAmount amount = TransactionAmount.create(4726.58);
		TransactionCreatedBy createdBy = TransactionCreatedBy.create(UUID.randomUUID().toString());
		TransactionAggregate transaction = new TransactionAggregate(id, reference, amount, createdBy);
		assertThat(transaction.getId()).isNotNull();
		assertThat(transaction.getId()).isEqualTo(id);
		assertThat(transaction.getReference()).isEqualTo(reference);
		assertThat(transaction.getAmount()).isEqualTo(amount);
		assertThat(transaction.getCreatedBy()).isEqualTo(createdBy);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		TransactionIdNotValid error = assertThrows(TransactionIdNotValid.class, () -> TransactionId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_reference_is_invalid() {
		TransactionReferenceNotValid
				error =
				assertThrows(TransactionReferenceNotValid.class, () -> TransactionReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
	}

	@Test
	void it_should_throw_when_amount_is_invalid() {
		TransactionAmountNotValid
				error =
				assertThrows(TransactionAmountNotValid.class, () -> TransactionAmount.create(null));
		assertThat(error.getMessage()).isEqualTo("Amount is invalid");
	}

	@Test
	void it_should_throw_when_createdBy_is_invalid() {
		TransactionCreatedByNotValid
				error =
				assertThrows(TransactionCreatedByNotValid.class, () -> TransactionCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
	}

}
