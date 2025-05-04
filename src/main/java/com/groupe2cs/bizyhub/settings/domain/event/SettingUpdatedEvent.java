package com.groupe2cs.bizyhub.settings.domain.event;

	import com.groupe2cs.bizyhub.settings.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingUpdatedEvent implements Serializable {

	private SettingId id;
	private SettingName name;
	private SettingReference reference;
	private SettingUpdatedAt updatedAt;
	private SettingStringValue stringValue;
	private SettingDescriptions descriptions;
	private SettingIsActive isActive;
	private SettingCreatedBy createdBy;
	private SettingTenant tenant;



}
