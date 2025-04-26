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
public class RoleCreatedEvent implements Serializable {

	private RoleId id;
	private RoleName name;
	private RoleCreatedBy createdBy;
	private RoleTenant tenant;



}
