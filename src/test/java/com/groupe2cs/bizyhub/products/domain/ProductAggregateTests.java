package com.groupe2cs.bizyhub.products.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.products.domain.exception.*;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;


public class ProductAggregateTests extends BaseUnitTests {

@Test
void it_should_create_product_with_valid_values() {
	ProductId id = ProductId.create(UUID.randomUUID().toString());
	ProductName name = ProductName.create(UUID.randomUUID().toString());
	ProductPrice price = ProductPrice.create(9364.52);
	ProductDetails details = ProductDetails.create(UUID.randomUUID().toString());
	ProductIsActive isActive = ProductIsActive.create(true);
	ProductUpdatedAt updatedAt = ProductUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	ProductReference reference = ProductReference.create(UUID.randomUUID().toString());
	ProductCreatedBy createdBy = ProductCreatedBy.create(UUID.randomUUID().toString());
	ProductTenant tenant = ProductTenant.create(UUID.randomUUID().toString());
	ProductAggregate aggregateProductAggregate = new ProductAggregate(id, name, price, details, isActive, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateProductAggregate.getId()).isNotNull();
	assertThat(aggregateProductAggregate.getId()).isEqualTo(id);
	assertThat(aggregateProductAggregate.getName()).isEqualTo(name);
	assertThat(aggregateProductAggregate.getPrice()).isEqualTo(price);
	assertThat(aggregateProductAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateProductAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateProductAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateProductAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateProductAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateProductAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		ProductIdNotValid error = assertThrows(ProductIdNotValid.class, () -> ProductId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		ProductNameNotValid error = assertThrows(ProductNameNotValid.class, () -> ProductName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_price_is_invalid() {
		ProductPriceNotValid error = assertThrows(ProductPriceNotValid.class, () -> ProductPrice.create(null));
		assertThat(error.getMessage()).isEqualTo("Price is invalid");
		}
		@Test
		void it_should_throw_when_details_is_invalid() {
		ProductDetailsNotValid error = assertThrows(ProductDetailsNotValid.class, () -> ProductDetails.create(""));
		assertThat(error.getMessage()).isEqualTo("Details is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		ProductIsActiveNotValid error = assertThrows(ProductIsActiveNotValid.class, () -> ProductIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		ProductUpdatedAtNotValid error = assertThrows(ProductUpdatedAtNotValid.class, () -> ProductUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		ProductReferenceNotValid error = assertThrows(ProductReferenceNotValid.class, () -> ProductReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		ProductCreatedByNotValid error = assertThrows(ProductCreatedByNotValid.class, () -> ProductCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		ProductTenantNotValid error = assertThrows(ProductTenantNotValid.class, () -> ProductTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
