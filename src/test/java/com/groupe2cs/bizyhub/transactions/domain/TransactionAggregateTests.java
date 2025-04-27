package com.groupe2cs.bizyhub.transactions.domain;

import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TransactionAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_transaction_with_valid_values() {
		TransactionId id = TransactionId.create(UUID.randomUUID().toString());
		TransactionReference reference = TransactionReference.create(UUID.randomUUID().toString());
		TransactionAmount amount = TransactionAmount.create(4406.52);
		TransactionCreatedBy createdBy = TransactionCreatedBy.create(UUID.randomUUID().toString());
		TransactionTenant tenant = TransactionTenant.create(UUID.randomUUID().toString());
		TransactionAggregate
				aggregateTransactionAggregate =
				new TransactionAggregate(id, reference, amount, createdBy, tenant);
		assertThat(aggregateTransactionAggregate.getId()).isNotNull();
		assertThat(aggregateTransactionAggregate.getId()).isEqualTo(id);
		assertThat(aggregateTransactionAggregate.getReference()).isEqualTo(reference);
		assertThat(aggregateTransactionAggregate.getAmount()).isEqualTo(amount);
		assertThat(aggregateTransactionAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateTransactionAggregate.getTenant()).isEqualTo(tenant);
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

	@Test
	void it_should_throw_when_tenant_is_invalid() {
		TransactionTenantNotValid
				error =
				assertThrows(TransactionTenantNotValid.class, () -> TransactionTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
	}

}
