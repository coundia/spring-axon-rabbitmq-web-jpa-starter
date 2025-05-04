package com.groupe2cs.bizyhub.sales.domain;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import java.util.UUID;
import com.groupe2cs.bizyhub.sales.domain.exception.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SaleAggregateTests extends BaseUnitTests {

@Test
void it_should_create_sale_with_valid_values() {
	SaleId id = SaleId.create(UUID.randomUUID().toString());
	SaleName name = SaleName.create(UUID.randomUUID().toString());
	SaleAmount amount = SaleAmount.create(6428.69);
	SaleDetails details = SaleDetails.create(UUID.randomUUID().toString());
	SaleIsActive isActive = SaleIsActive.create(false);
	SaleUpdatedAt updatedAt = SaleUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	SaleReference reference = SaleReference.create(UUID.randomUUID().toString());
	SaleCreatedBy createdBy = SaleCreatedBy.create(UUID.randomUUID().toString());
	SaleTenant tenant = SaleTenant.create(UUID.randomUUID().toString());
	SaleAggregate aggregateSaleAggregate = new SaleAggregate(id, name, amount, details, isActive, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateSaleAggregate.getId()).isNotNull();
	assertThat(aggregateSaleAggregate.getId()).isEqualTo(id);
	assertThat(aggregateSaleAggregate.getName()).isEqualTo(name);
	assertThat(aggregateSaleAggregate.getAmount()).isEqualTo(amount);
	assertThat(aggregateSaleAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateSaleAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateSaleAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateSaleAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateSaleAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateSaleAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		SaleIdNotValid error = assertThrows(SaleIdNotValid.class, () -> SaleId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		SaleNameNotValid error = assertThrows(SaleNameNotValid.class, () -> SaleName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_amount_is_invalid() {
		SaleAmountNotValid error = assertThrows(SaleAmountNotValid.class, () -> SaleAmount.create(null));
		assertThat(error.getMessage()).isEqualTo("Amount is invalid");
		}
		@Test
		void it_should_throw_when_details_is_invalid() {
		SaleDetailsNotValid error = assertThrows(SaleDetailsNotValid.class, () -> SaleDetails.create(""));
		assertThat(error.getMessage()).isEqualTo("Details is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		SaleIsActiveNotValid error = assertThrows(SaleIsActiveNotValid.class, () -> SaleIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		SaleUpdatedAtNotValid error = assertThrows(SaleUpdatedAtNotValid.class, () -> SaleUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		SaleReferenceNotValid error = assertThrows(SaleReferenceNotValid.class, () -> SaleReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		SaleCreatedByNotValid error = assertThrows(SaleCreatedByNotValid.class, () -> SaleCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		SaleTenantNotValid error = assertThrows(SaleTenantNotValid.class, () -> SaleTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
