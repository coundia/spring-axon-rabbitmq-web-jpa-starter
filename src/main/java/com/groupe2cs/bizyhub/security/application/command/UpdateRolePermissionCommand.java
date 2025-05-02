package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

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
public class UpdateRolePermissionCommand implements Serializable {
@TargetAggregateIdentifier
	private RolePermissionId id;
 	private RolePermissionRole role;
 	private RolePermissionPermission permission;
 	private RolePermissionCreatedBy createdBy;
 	private RolePermissionTenant tenant;


}
