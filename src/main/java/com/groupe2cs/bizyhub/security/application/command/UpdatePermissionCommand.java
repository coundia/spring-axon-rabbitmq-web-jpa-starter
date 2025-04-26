package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionName;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionTenant;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePermissionCommand implements Serializable {
	@TargetAggregateIdentifier
	private PermissionId id;
	private PermissionName name;
	private PermissionCreatedBy createdBy;
	private PermissionTenant tenant;


}
