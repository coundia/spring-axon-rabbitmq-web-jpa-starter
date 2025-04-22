package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleName;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRoleCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private RoleId id = RoleId.create(UUID.randomUUID().toString());
	private RoleName name;

	public CreateRoleCommand(

			RoleName name
	) {
		this.id = RoleId.create(UUID.randomUUID().toString());

		this.name = name;
	}


}
