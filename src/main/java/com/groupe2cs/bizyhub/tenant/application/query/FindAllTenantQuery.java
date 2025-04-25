package com.groupe2cs.bizyhub.tenant.application.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindAllTenantQuery {

	private final int page;
	private final int limit;

}
