package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.RoleCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleName;
import com.groupe2cs.bizyhub.security.domain.valueObject.RoleTenant;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRoleCommand implements Serializable {
	@TargetAggregateIdentifier
	private RoleId id;
	private RoleName name;
	private RoleCreatedBy createdBy;
	private RoleTenant tenant;


}
