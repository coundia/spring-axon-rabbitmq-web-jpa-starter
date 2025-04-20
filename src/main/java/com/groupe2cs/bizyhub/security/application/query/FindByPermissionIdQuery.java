package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByPermissionIdQuery {

private final PermissionId  id;

public FindByPermissionIdQuery( PermissionId id) {
	this.id = id;
}

public PermissionId  getId() {
return id;
}
}
