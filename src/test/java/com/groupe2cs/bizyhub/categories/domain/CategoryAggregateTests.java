package com.groupe2cs.bizyhub.categories.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.categories.domain.exception.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;


public class CategoryAggregateTests extends BaseUnitTests {

@Test
void it_should_create_category_with_valid_values() {
	CategoryId id = CategoryId.create(UUID.randomUUID().toString());
	CategoryName name = CategoryName.create(UUID.randomUUID().toString());
	CategoryTypeCategoryRaw typeCategoryRaw = CategoryTypeCategoryRaw.create(UUID.randomUUID().toString());
	CategoryDetails details = CategoryDetails.create(UUID.randomUUID().toString());
	CategoryIsActive isActive = CategoryIsActive.create(true);
	CategoryUpdatedAt updatedAt = CategoryUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	CategoryReference reference = CategoryReference.create(UUID.randomUUID().toString());
	CategoryCreatedBy createdBy = CategoryCreatedBy.create(UUID.randomUUID().toString());
	CategoryTenant tenant = CategoryTenant.create(UUID.randomUUID().toString());
	CategoryAggregate aggregateCategoryAggregate = new CategoryAggregate(id, name, typeCategoryRaw, details, isActive, updatedAt, reference, createdBy, tenant);
	assertThat(aggregateCategoryAggregate.getId()).isNotNull();
	assertThat(aggregateCategoryAggregate.getId()).isEqualTo(id);
	assertThat(aggregateCategoryAggregate.getName()).isEqualTo(name);
	assertThat(aggregateCategoryAggregate.getTypeCategoryRaw()).isEqualTo(typeCategoryRaw);
	assertThat(aggregateCategoryAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateCategoryAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateCategoryAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateCategoryAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateCategoryAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateCategoryAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		CategoryIdNotValid error = assertThrows(CategoryIdNotValid.class, () -> CategoryId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		CategoryNameNotValid error = assertThrows(CategoryNameNotValid.class, () -> CategoryName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_typeCategoryRaw_is_invalid() {
		CategoryTypeCategoryRawNotValid error = assertThrows(CategoryTypeCategoryRawNotValid.class, () -> CategoryTypeCategoryRaw.create(""));
		assertThat(error.getMessage()).isEqualTo("TypeCategoryRaw is invalid");
		}
		@Test
		void it_should_throw_when_details_is_invalid() {
		CategoryDetailsNotValid error = assertThrows(CategoryDetailsNotValid.class, () -> CategoryDetails.create(""));
		assertThat(error.getMessage()).isEqualTo("Details is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		CategoryIsActiveNotValid error = assertThrows(CategoryIsActiveNotValid.class, () -> CategoryIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		CategoryUpdatedAtNotValid error = assertThrows(CategoryUpdatedAtNotValid.class, () -> CategoryUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		CategoryReferenceNotValid error = assertThrows(CategoryReferenceNotValid.class, () -> CategoryReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		CategoryCreatedByNotValid error = assertThrows(CategoryCreatedByNotValid.class, () -> CategoryCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		CategoryTenantNotValid error = assertThrows(CategoryTenantNotValid.class, () -> CategoryTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
