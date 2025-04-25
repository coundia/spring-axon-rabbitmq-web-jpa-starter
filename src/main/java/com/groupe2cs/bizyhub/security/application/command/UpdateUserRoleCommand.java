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
public class UpdateUserRoleCommand implements Serializable {
	@TargetAggregateIdentifier
	private UserRoleId id;
	private UserRoleUser user;
	private UserRoleRole role;
	private UserRoleCreatedBy createdBy;
	private UserRoleTenant tenant;


}
