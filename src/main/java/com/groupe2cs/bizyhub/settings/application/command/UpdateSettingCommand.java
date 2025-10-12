package com.groupe2cs.bizyhub.settings.application.command;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSettingCommand implements Serializable {
	@TargetAggregateIdentifier
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
