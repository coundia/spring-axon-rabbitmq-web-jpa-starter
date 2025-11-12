package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRolePermissionCommand implements Serializable {
	@TargetAggregateIdentifier
	private RolePermissionId id;
	private RolePermissionRole role;
	private RolePermissionPermission permission;
	private RolePermissionCreatedBy createdBy;
	private RolePermissionTenant tenant;


}
