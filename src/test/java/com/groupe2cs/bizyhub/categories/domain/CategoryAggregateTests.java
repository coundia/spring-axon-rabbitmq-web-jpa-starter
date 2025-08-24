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
	CategoryCode code = CategoryCode.create(UUID.randomUUID().toString());
	CategoryName name = CategoryName.create(UUID.randomUUID().toString());
	CategoryRemoteId remoteId = CategoryRemoteId.create(UUID.randomUUID().toString());
	CategoryDescription description = CategoryDescription.create(UUID.randomUUID().toString());
	CategoryTypeEntry typeEntry = CategoryTypeEntry.create(UUID.randomUUID().toString());
	CategoryVersion version = CategoryVersion.create(23);
	CategorySyncAt syncAt = CategorySyncAt.create(java.time.Instant.now().plusSeconds(3600));
	CategoryCreatedBy createdBy = CategoryCreatedBy.create(UUID.randomUUID().toString());
	CategoryTenant tenant = CategoryTenant.create(UUID.randomUUID().toString());
	CategoryAggregate aggregateCategoryAggregate = new CategoryAggregate(id, code, name, remoteId, description, typeEntry, version, syncAt, createdBy, tenant);
	assertThat(aggregateCategoryAggregate.getId()).isNotNull();
	assertThat(aggregateCategoryAggregate.getId()).isEqualTo(id);
	assertThat(aggregateCategoryAggregate.getCode()).isEqualTo(code);
	assertThat(aggregateCategoryAggregate.getName()).isEqualTo(name);
	assertThat(aggregateCategoryAggregate.getRemoteId()).isEqualTo(remoteId);
	assertThat(aggregateCategoryAggregate.getDescription()).isEqualTo(description);
	assertThat(aggregateCategoryAggregate.getTypeEntry()).isEqualTo(typeEntry);
	assertThat(aggregateCategoryAggregate.getVersion()).isEqualTo(version);
	assertThat(aggregateCategoryAggregate.getSyncAt()).isEqualTo(syncAt);
	assertThat(aggregateCategoryAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateCategoryAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		CategoryIdNotValid error = assertThrows(CategoryIdNotValid.class, () -> CategoryId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_code_is_invalid() {
		CategoryCodeNotValid error = assertThrows(CategoryCodeNotValid.class, () -> CategoryCode.create(""));
		assertThat(error.getMessage()).isEqualTo("Code is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		CategoryNameNotValid error = assertThrows(CategoryNameNotValid.class, () -> CategoryName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}

}
