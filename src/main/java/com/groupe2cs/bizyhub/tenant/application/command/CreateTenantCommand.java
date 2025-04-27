package com.groupe2cs.bizyhub.tenant.application.command;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTenantCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private TenantId id = TenantId.create(UUID.randomUUID().toString());
	private TenantName name;
	private TenantDescription description;
	private TenantDomain domain;
	private TenantLanguage language;
	private TenantActive active;
	private TenantTenant tenant;
	private TenantCreatedBy createdBy;

	public CreateTenantCommand(

			TenantName name,
			TenantDescription description,
			TenantDomain domain,
			TenantLanguage language,
			TenantActive active,
			TenantTenant tenant,
			TenantCreatedBy createdBy
	) {
		this.id = TenantId.create(UUID.randomUUID().toString());

		this.name = name;
		this.description = description;
		this.domain = domain;
		this.language = language;
		this.active = active;
		this.tenant = tenant;
		this.createdBy = createdBy;
	}


}
