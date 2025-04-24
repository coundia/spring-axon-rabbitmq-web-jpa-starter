package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleRole;
import com.groupe2cs.bizyhub.security.domain.valueObject.UserRoleUser;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRoleCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private UserRoleId id = UserRoleId.create(UUID.randomUUID().toString());
	private UserRoleUser user;
	private UserRoleRole role;
	private UserRoleCreatedBy createdBy;

	public CreateUserRoleCommand(

			UserRoleUser user,
			UserRoleRole role,
			UserRoleCreatedBy createdBy
	) {
		this.id = UserRoleId.create(UUID.randomUUID().toString());

		this.user = user;
		this.role = role;
		this.createdBy = createdBy;
	}


}
