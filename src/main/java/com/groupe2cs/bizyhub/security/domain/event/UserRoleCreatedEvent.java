package com.groupe2cs.bizyhub.security.domain.event;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleCreatedEvent implements Serializable {

	private UserRoleId id;
	private UserRoleUser user;
	private UserRoleRole role;
	private UserRoleCreatedBy createdBy;
	private UserRoleTenant tenant;


}
