package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByPermissionNameQuery {

private final PermissionName  name;

public FindByPermissionNameQuery( PermissionName name) {
	this.name = name;
}

public PermissionName  getName() {
return name;
}
}
