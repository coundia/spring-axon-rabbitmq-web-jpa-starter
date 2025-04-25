package com.groupe2cs.bizyhub.tenant.domain.event;

	import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenantUpdatedEvent implements Serializable {

	private TenantId id;
	private TenantName name;
	private TenantDescription description;
	private TenantDomain domain;
	private TenantLanguage language;
	private TenantActive active;
	private TenantCreatedBy createdBy;



}
