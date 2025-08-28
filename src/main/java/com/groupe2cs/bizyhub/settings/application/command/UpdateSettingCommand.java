package com.groupe2cs.bizyhub.settings.application.command;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

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
