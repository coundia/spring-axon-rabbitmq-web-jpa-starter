package com.groupe2cs.bizyhub.settings.domain;

import com.groupe2cs.bizyhub.settings.domain.exception.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.BaseUnitTests;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SettingAggregateTests extends BaseUnitTests {

	@Test
	void it_should_create_setting_with_valid_values() {
		SettingId id = SettingId.create(UUID.randomUUID().toString());
		SettingName name = SettingName.create(UUID.randomUUID().toString());
		SettingStringValue stringValue = SettingStringValue.create(UUID.randomUUID().toString());
		SettingDescription description = SettingDescription.create(UUID.randomUUID().toString());
		SettingIsActive isActive = SettingIsActive.create(false);
		SettingCreatedBy createdBy = SettingCreatedBy.create(UUID.randomUUID().toString());
		SettingTenant tenant = SettingTenant.create(UUID.randomUUID().toString());
		SettingAggregate
				aggregateSettingAggregate =
				new SettingAggregate(id, name, stringValue, description, isActive, createdBy, tenant);
		assertThat(aggregateSettingAggregate.getId()).isNotNull();
		assertThat(aggregateSettingAggregate.getId()).isEqualTo(id);
		assertThat(aggregateSettingAggregate.getName()).isEqualTo(name);
		assertThat(aggregateSettingAggregate.getStringValue()).isEqualTo(stringValue);
		assertThat(aggregateSettingAggregate.getDescription()).isEqualTo(description);
		assertThat(aggregateSettingAggregate.getIsActive()).isEqualTo(isActive);
		assertThat(aggregateSettingAggregate.getCreatedBy()).isEqualTo(createdBy);
		assertThat(aggregateSettingAggregate.getTenant()).isEqualTo(tenant);
	}

	@Test
	void it_should_throw_when_id_is_invalid() {
		SettingIdNotValid error = assertThrows(SettingIdNotValid.class, () -> SettingId.create(""));
		assertThat(error.getMessage()).isEqualTo("Id is invalid");
	}

	@Test
	void it_should_throw_when_name_is_invalid() {
		SettingNameNotValid error = assertThrows(SettingNameNotValid.class, () -> SettingName.create(""));
		assertThat(error.getMessage()).isEqualTo("Name is invalid");
	}

	@Test
	void it_should_throw_when_stringValue_is_invalid() {
		SettingStringValueNotValid
				error =
				assertThrows(SettingStringValueNotValid.class, () -> SettingStringValue.create(""));
		assertThat(error.getMessage()).isEqualTo("StringValue is invalid");
	}

	@Test
	void it_should_throw_when_description_is_invalid() {
		SettingDescriptionNotValid
				error =
				assertThrows(SettingDescriptionNotValid.class, () -> SettingDescription.create(""));
		assertThat(error.getMessage()).isEqualTo("Description is invalid");
	}

	@Test
	void it_should_throw_when_isActive_is_invalid() {
		SettingIsActiveNotValid error = assertThrows(SettingIsActiveNotValid.class, () -> SettingIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
	}

	@Test
	void it_should_throw_when_createdBy_is_invalid() {
		SettingCreatedByNotValid
				error =
				assertThrows(SettingCreatedByNotValid.class, () -> SettingCreatedBy.create(""));
		assertThat(error.getMessage()).isEqualTo("CreatedBy is invalid");
	}

	@Test
	void it_should_throw_when_tenant_is_invalid() {
		SettingTenantNotValid error = assertThrows(SettingTenantNotValid.class, () -> SettingTenant.create(""));
		assertThat(error.getMessage()).isEqualTo("Tenant is invalid");
	}

}
