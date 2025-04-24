package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionPermission;
import com.groupe2cs.bizyhub.security.domain.valueObject.RolePermissionRole;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRolePermissionCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private RolePermissionId id = RolePermissionId.create(UUID.randomUUID().toString());
	private RolePermissionRole role;
	private RolePermissionPermission permission;
	private RolePermissionCreatedBy createdBy;

	public CreateRolePermissionCommand(

			RolePermissionRole role,
			RolePermissionPermission permission,
			RolePermissionCreatedBy createdBy
	) {
		this.id = RolePermissionId.create(UUID.randomUUID().toString());

		this.role = role;
		this.permission = permission;
		this.createdBy = createdBy;
	}


}
