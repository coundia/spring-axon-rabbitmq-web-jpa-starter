package com.groupe2cs.bizyhub.sales.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import java.util.UUID;
import com.groupe2cs.bizyhub.sales.domain.exception.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import com.groupe2cs.bizyhub.shared.*;


public class SaleUserAggregateTests extends BaseUnitTests {

@Test
void it_should_create_saleUser_with_valid_values() {
	SaleUserId id = SaleUserId.create(UUID.randomUUID().toString());
	SaleUserSales sales = SaleUserSales.create(UUID.randomUUID().toString());
	SaleUserUsers users = SaleUserUsers.create(UUID.randomUUID().toString());
	SaleUserDetails details = SaleUserDetails.create(UUID.randomUUID().toString());
	SaleUserIsActive isActive = SaleUserIsActive.create(true);
	SaleUserUpdatedAt updatedAt = SaleUserUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	SaleUserReference reference = SaleUserReference.create(UUID.randomUUID().toString());
	SaleUserCreatedBy createdBy = SaleUserCreatedBy.create(UUID.randomUUID().toString());
	SaleUserTenant tenant = SaleUserTenant.create(UUID.randomUUID().toString());
	SaleUserAggregate aggregateSaleUserAggregate = new SaleUserAggregate(id, sales, users, details, isActive, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateSaleUserAggregate.getId()).isNotNull();
	assertThat(aggregateSaleUserAggregate.getId()).isEqualTo(id);
	assertThat(aggregateSaleUserAggregate.getSales()).isEqualTo(sales);
	assertThat(aggregateSaleUserAggregate.getUsers()).isEqualTo(users);
	assertThat(aggregateSaleUserAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateSaleUserAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateSaleUserAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateSaleUserAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateSaleUserAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateSaleUserAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		SaleUserIdNotValid error = assertThrows(SaleUserIdNotValid.class, () -> SaleUserId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_sales_is_invalid() {
		SaleUserSalesNotValid error = assertThrows(SaleUserSalesNotValid.class, () -> SaleUserSales.create(""));
		assertThat(error.getMessage()).isEqualTo("Sales is invalid");
		}
		@Test
		void it_should_throw_when_users_is_invalid() {
		SaleUserUsersNotValid error = assertThrows(SaleUserUsersNotValid.class, () -> SaleUserUsers.create(""));
		assertThat(error.getMessage()).isEqualTo("Users is invalid");
		}
		@Test
		void it_should_throw_when_details_is_invalid() {
		SaleUserDetailsNotValid error = assertThrows(SaleUserDetailsNotValid.class, () -> SaleUserDetails.create(""));
		assertThat(error.getMessage()).isEqualTo("Details is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		SaleUserIsActiveNotValid error = assertThrows(SaleUserIsActiveNotValid.class, () -> SaleUserIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		SaleUserUpdatedAtNotValid error = assertThrows(SaleUserUpdatedAtNotValid.class, () -> SaleUserUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		SaleUserReferenceNotValid error = assertThrows(SaleUserReferenceNotValid.class, () -> SaleUserReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		SaleUserCreatedByNotValid error = assertThrows(SaleUserCreatedByNotValid.class, () -> SaleUserCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		SaleUserTenantNotValid error = assertThrows(SaleUserTenantNotValid.class, () -> SaleUserTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
