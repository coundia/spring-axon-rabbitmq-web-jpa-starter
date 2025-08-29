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
public class SettingCreatedEvent implements Serializable {

	private SettingId id;
	private SettingName name;
	private SettingValue value;
	private SettingLocale locale;
	private SettingRemoteId remoteId;
	private SettingLocalId localId;
	private SettingAccount account;
	private SettingDetails details;
	private SettingSyncAt syncAt;
	private SettingIsActive isActive;
	private SettingCreatedBy createdBy;
	private SettingTenant tenant;


}
