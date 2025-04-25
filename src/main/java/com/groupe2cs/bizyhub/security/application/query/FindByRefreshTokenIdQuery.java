package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

public class FindByRefreshTokenIdQuery {

private final RefreshTokenId  id;

public FindByRefreshTokenIdQuery( RefreshTokenId id) {
	this.id = id;
}

public RefreshTokenId  getId() {
return id;
}
}
