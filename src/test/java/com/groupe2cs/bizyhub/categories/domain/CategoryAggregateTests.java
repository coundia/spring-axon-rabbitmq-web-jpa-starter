package com.groupe2cs.bizyhub.categories.domain;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.*;
import com.groupe2cs.bizyhub.categories.domain.exception.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class CategoryAggregateTests extends BaseUnitTests {

@Test
void it_should_create_category_with_valid_values() {
	CategoryId id = CategoryId.create(UUID.randomUUID().toString());
	CategoryName name = CategoryName.create(UUID.randomUUID().toString());
	CategoryTypeCategoryRaw typeCategoryRaw = CategoryTypeCategoryRaw.create(UUID.randomUUID().toString());
	CategoryDetails details = CategoryDetails.create(UUID.randomUUID().toString());
	CategoryIsActive isActive = CategoryIsActive.create(true);
	CategoryCreatedBy createdBy = CategoryCreatedBy.create(UUID.randomUUID().toString());
	CategoryTenant tenant = CategoryTenant.create(UUID.randomUUID().toString());
	CategoryAggregate aggregateCategoryAggregate = new CategoryAggregate(id, name, typeCategoryRaw, details, isActive, createdBy, tenant);
	assertThat(aggregateCategoryAggregate.getId()).isNotNull();
	assertThat(aggregateCategoryAggregate.getId()).isEqualTo(id);
	assertThat(aggregateCategoryAggregate.getName()).isEqualTo(name);
	assertThat(aggregateCategoryAggregate.getTypeCategoryRaw()).isEqualTo(typeCategoryRaw);
	assertThat(aggregateCategoryAggregate.getDetails()).isEqualTo(details);
	assertThat(aggregateCategoryAggregate.getIsActive()).isEqualTo(isActive);
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
		void it_should_throw_when_isActive_is_invalid() {
		CategoryIsActiveNotValid error = assertThrows(CategoryIsActiveNotValid.class, () -> CategoryIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}

}
