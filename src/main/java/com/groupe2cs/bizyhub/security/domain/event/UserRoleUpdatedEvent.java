package com.groupe2cs.bizyhub.security.domain.event;

	import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleUpdatedEvent implements Serializable {

	private UserRoleId id;
	private UserRoleUser user;
	private UserRoleRole role;
	private UserRoleCreatedBy createdBy;
	private UserRoleTenant tenant;



}
