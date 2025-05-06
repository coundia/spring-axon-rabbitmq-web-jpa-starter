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
public class PermissionUpdatedEvent implements Serializable {

	private PermissionId id;
	private PermissionName name;
	private PermissionCreatedBy createdBy;
	private PermissionTenant tenant;



}
