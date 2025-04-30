package com.groupe2cs.bizyhub.settings.domain.event;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingUpdatedEvent implements Serializable {

	private SettingId id;
	private SettingName name;
	private SettingStringValue stringValue;
	private SettingDescription description;
	private SettingIsActive isActive;
	private SettingCreatedBy createdBy;
	private SettingTenant tenant;


}
