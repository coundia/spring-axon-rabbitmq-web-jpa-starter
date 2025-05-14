package com.groupe2cs.bizyhub.settings.application.command;

import com.groupe2cs.bizyhub.settings.domain.valueObject.SettingId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteSettingCommand implements Serializable {
	@TargetAggregateIdentifier
	private SettingId id;


}
