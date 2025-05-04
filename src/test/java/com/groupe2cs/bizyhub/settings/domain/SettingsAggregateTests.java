package com.groupe2cs.bizyhub.settings.domain;

import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.UUID;
import com.groupe2cs.bizyhub.settings.domain.exception.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SettingsAggregateTests extends BaseUnitTests {

@Test
void it_should_create_settings_with_valid_values() {
	SettingsId id = SettingsId.create(UUID.randomUUID().toString());
	SettingsName name = SettingsName.create(UUID.randomUUID().toString());
	SettingsReference reference = SettingsReference.create(UUID.randomUUID().toString());
	SettingsUpdatedAt updatedAt = SettingsUpdatedAt.create(java.time.Instant.now().plusSeconds(3600));
	SettingsStringValue stringValue = SettingsStringValue.create(UUID.randomUUID().toString());
	SettingsDescriptions descriptions = SettingsDescriptions.create(UUID.randomUUID().toString());
	SettingsIsActive isActive = SettingsIsActive.create(true);
	SettingsCreatedBy createdBy = SettingsCreatedBy.create(UUID.randomUUID().toString());
	SettingsTenant tenant = SettingsTenant.create(UUID.randomUUID().toString());
	SettingsAggregate aggregateSettingsAggregate = new SettingsAggregate(id, name, reference, updatedAt, stringValue, descriptions, isActive, createdBy, tenant);
	assertThat(aggregateSettingsAggregate.getId()).isNotNull();
	assertThat(aggregateSettingsAggregate.getId()).isEqualTo(id);
	assertThat(aggregateSettingsAggregate.getName()).isEqualTo(name);
	assertThat(aggregateSettingsAggregate.getReference()).isEqualTo(reference);
	assertThat(aggregateSettingsAggregate.getUpdatedAt()).isEqualTo(updatedAt);
	assertThat(aggregateSettingsAggregate.getStringValue()).isEqualTo(stringValue);
	assertThat(aggregateSettingsAggregate.getDescriptions()).isEqualTo(descriptions);
	assertThat(aggregateSettingsAggregate.getIsActive()).isEqualTo(isActive);
	assertThat(aggregateSettingsAggregate.getCreatedBy()).isEqualTo(createdBy);
	assertThat(aggregateSettingsAggregate.getTenant()).isEqualTo(tenant);
}

		@Test
		void it_should_throw_when_id_is_invalid() {
		SettingsIdNotValid error = assertThrows(SettingsIdNotValid.class, () -> SettingsId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
		}
		@Test
		void it_should_throw_when_name_is_invalid() {
		SettingsNameNotValid error = assertThrows(SettingsNameNotValid.class, () -> SettingsName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
		}
		@Test
		void it_should_throw_when_reference_is_invalid() {
		SettingsReferenceNotValid error = assertThrows(SettingsReferenceNotValid.class, () -> SettingsReference.create(""));
		assertThat(error.getMessage()).isEqualTo("Reference is invalid");
		}
		@Test
		void it_should_throw_when_updatedAt_is_invalid() {
		SettingsUpdatedAtNotValid error = assertThrows(SettingsUpdatedAtNotValid.class, () -> SettingsUpdatedAt.create(null));
		assertThat(error.getMessage()).isEqualTo("UpdatedAt is invalid");
		}
		@Test
		void it_should_throw_when_stringValue_is_invalid() {
		SettingsStringValueNotValid error = assertThrows(SettingsStringValueNotValid.class, () -> SettingsStringValue.create(""));
		assertThat(error.getMessage()).isEqualTo("StringValue is invalid");
		}
		@Test
		void it_should_throw_when_descriptions_is_invalid() {
		SettingsDescriptionsNotValid error = assertThrows(SettingsDescriptionsNotValid.class, () -> SettingsDescriptions.create(""));
		assertThat(error.getMessage()).isEqualTo("Descriptions is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		SettingsIsActiveNotValid error = assertThrows(SettingsIsActiveNotValid.class, () -> SettingsIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}
		@Test
		void it_should_throw_when_createdBy_is_invalid() {
		SettingsCreatedByNotValid error = assertThrows(SettingsCreatedByNotValid.class, () -> SettingsCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
		}
		@Test
		void it_should_throw_when_tenant_is_invalid() {
		SettingsTenantNotValid error = assertThrows(SettingsTenantNotValid.class, () -> SettingsTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
		}

}
