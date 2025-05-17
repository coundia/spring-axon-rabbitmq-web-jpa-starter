package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionCreatedBy;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionId;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionName;
import com.groupe2cs.bizyhub.security.domain.valueObject.PermissionTenant;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePermissionCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private PermissionId id = PermissionId.create(UUID.randomUUID().toString());
	private PermissionName name;
	private PermissionCreatedBy createdBy;
	private PermissionTenant tenant;

	public CreatePermissionCommand(

			PermissionName name,
			PermissionCreatedBy createdBy,
			PermissionTenant tenant
	) {
		this.id = PermissionId.create(UUID.randomUUID().toString());

		this.name = name;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
