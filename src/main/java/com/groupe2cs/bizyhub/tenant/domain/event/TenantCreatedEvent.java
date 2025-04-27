package com.groupe2cs.bizyhub.tenant.domain.event;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenantCreatedEvent implements Serializable {

	private TenantId id;
	private TenantName name;
	private TenantDescription description;
	private TenantDomain domain;
	private TenantLanguage language;
	private TenantActive active;
	private TenantTenant tenant;
	private TenantCreatedBy createdBy;


}
