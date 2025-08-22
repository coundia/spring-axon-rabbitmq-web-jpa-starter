package com.groupe2cs.bizyhub.settings.domain;

import java.util.UUID;
import com.groupe2cs.bizyhub.settings.domain.exception.*;
import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.groupe2cs.bizyhub.shared.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class SettingAggregateTests extends BaseUnitTests {

@Test
void it_should_create_setting_with_valid_values() {
	SettingId id = SettingId.create(UUID.randomUUID().toString());
	SettingName name = SettingName.create(UUID.randomUUID().toString());
	SettingValue value = SettingValue.create(UUID.randomUUID().toString());
	SettingLocale locale = SettingLocale.create(UUID.randomUUID().toString());
	SettingDetails details = SettingDetails.create(UUID.randomUUID().toString());
	SettingIsActive isActive = SettingIsActive.create(false);
	SettingCreatedBy createdBy = SettingCreatedBy.create(UUID.randomUUID().toString());
	SettingTenant tenant = SettingTenant.create(UUID.randomUUID().toString());
	SettingAggregate aggregateSettingAggregate = new SettingAggregate(id, name, value, locale, details, isActive, createdBy, tenant);
	assertThat(aggregateSettingAggregate.getId()).isNotNull();
	assertThat(aggregateSettingAggregate.getId()).isEqualTo(id);
	assertThat(aggregateSettingAggregate.getName()).isEqualTo(name);
	assertThat(aggregateSettingAggregate.getValue()).isEqualTo(value);
	assertThat(aggregateSettingAggregate.getLocale()).isEqualTo(locale);
	assertThat(aggregateSettingAggregate.getDetails()).isEqualTo(details);
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
		void it_should_throw_when_value_is_invalid() {
		SettingValueNotValid error = assertThrows(SettingValueNotValid.class, () -> SettingValue.create(""));
		assertThat(error.getMessage()).isEqualTo("Value is invalid");
		}
		@Test
		void it_should_throw_when_locale_is_invalid() {
		SettingLocaleNotValid error = assertThrows(SettingLocaleNotValid.class, () -> SettingLocale.create(""));
		assertThat(error.getMessage()).isEqualTo("Locale is invalid");
		}
		@Test
		void it_should_throw_when_isActive_is_invalid() {
		SettingIsActiveNotValid error = assertThrows(SettingIsActiveNotValid.class, () -> SettingIsActive.create(null));
		assertThat(error.getMessage()).isEqualTo("IsActive is invalid");
		}

}
