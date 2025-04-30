package com.groupe2cs.bizyhub.settings.application.command;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSettingCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private SettingId id = SettingId.create(UUID.randomUUID().toString());
	private SettingName name;
	private SettingStringValue stringValue;
	private SettingDescription description;
	private SettingIsActive isActive;
	private SettingCreatedBy createdBy;
	private SettingTenant tenant;

	public CreateSettingCommand(

			SettingName name,
			SettingStringValue stringValue,
			SettingDescription description,
			SettingIsActive isActive,
			SettingCreatedBy createdBy,
			SettingTenant tenant
	) {
		this.id = SettingId.create(UUID.randomUUID().toString());

		this.name = name;
		this.stringValue = stringValue;
		this.description = description;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
