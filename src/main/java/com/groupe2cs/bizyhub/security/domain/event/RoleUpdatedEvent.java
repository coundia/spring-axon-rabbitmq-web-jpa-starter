package com.groupe2cs.bizyhub.security.domain.event;

	import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleUpdatedEvent implements Serializable {

	private RoleId id;
	private RoleName name;
	private RoleCreatedBy createdBy;
	private RoleTenant tenant;



}
