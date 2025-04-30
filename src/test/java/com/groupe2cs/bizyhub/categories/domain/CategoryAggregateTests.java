package com.groupe2cs.bizyhub.categories.domain;

import com.groupe2cs.bizyhub.categories.domain.exception.*;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CategoryAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_category_with_valid_values() {
		CategoryId id = CategoryId.create(UUID.randomUUID().toString());
		CategoryName name = CategoryName.create(UUID.randomUUID().toString());
		CategoryTypeCategory typeCategory = CategoryTypeCategory.create(UUID.randomUUID().toString());
		CategoryParentId parentId = CategoryParentId.create(UUID.randomUUID().toString());
		CategoryIsDefault isDefault = CategoryIsDefault.create(false);
		CategoryIcon icon = CategoryIcon.create(UUID.randomUUID().toString());
		CategoryColorHex colorHex = CategoryColorHex.create(UUID.randomUUID().toString());
		CategoryCreatedBy createdBy = CategoryCreatedBy.create(UUID.randomUUID().toString());
		CategoryTenant tenant = CategoryTenant.create(UUID.randomUUID().toString());
		CategoryAggregate
				aggregateCategoryAggregate =
				new CategoryAggregate(id, name, typeCategory, parentId, isDefault, icon, colorHex, createdBy, tenant);
		assertThat(aggregateCategoryAggregate.getId()).isNotNull();
		assertThat(aggregateCategoryAggregate.getId()).isEqualTo(id);
		assertThat(aggregateCategoryAggregate.getName()).isEqualTo(name);
		assertThat(aggregateCategoryAggregate.getTypeCategory()).isEqualTo(typeCategory);
		assertThat(aggregateCategoryAggregate.getParentId()).isEqualTo(parentId);
		assertThat(aggregateCategoryAggregate.getIsDefault()).isEqualTo(isDefault);
		assertThat(aggregateCategoryAggregate.getIcon()).isEqualTo(icon);
		assertThat(aggregateCategoryAggregate.getColorHex()).isEqualTo(colorHex);
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
	void it_should_throw_when_typeCategory_is_invalid() {
		CategoryTypeCategoryNotValid
				error =
				assertThrows(CategoryTypeCategoryNotValid.class, () -> CategoryTypeCategory.create(""));
		assertThat(error.getMessage()).isEqualTo("TypeCategory is invalid");
	}

	@Test
	void it_should_throw_when_parentId_is_invalid() {
		CategoryParentIdNotValid
				error =
				assertThrows(CategoryParentIdNotValid.class, () -> CategoryParentId.create(""));
		assertThat(error.getMessage()).isEqualTo("ParentId is invalid");
	}

	@Test
	void it_should_throw_when_isDefault_is_invalid() {
		CategoryIsDefaultNotValid
				error =
				assertThrows(CategoryIsDefaultNotValid.class, () -> CategoryIsDefault.create(null));
		assertThat(error.getMessage()).isEqualTo("IsDefault is invalid");
	}

	@Test
	void it_should_throw_when_icon_is_invalid() {
		CategoryIconNotValid error = assertThrows(CategoryIconNotValid.class, () -> CategoryIcon.create(""));
		assertThat(error.getMessage()).isEqualTo("Icon is invalid");
	}

	@Test
	void it_should_throw_when_colorHex_is_invalid() {
		CategoryColorHexNotValid
				error =
				assertThrows(CategoryColorHexNotValid.class, () -> CategoryColorHex.create(""));
		assertThat(error.getMessage()).isEqualTo("ColorHex is invalid");
	}

	@Test
	void it_should_throw_when_createdBy_is_invalid() {
		CategoryCreatedByNotValid
				error =
				assertThrows(CategoryCreatedByNotValid.class, () -> CategoryCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
	}

	@Test
	void it_should_throw_when_tenant_is_invalid() {
		CategoryTenantNotValid error = assertThrows(CategoryTenantNotValid.class, () -> CategoryTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
	}

}
