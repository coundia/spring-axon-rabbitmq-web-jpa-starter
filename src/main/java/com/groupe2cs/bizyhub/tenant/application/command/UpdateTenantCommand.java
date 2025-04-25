package com.groupe2cs.bizyhub.tenant.application.command;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTenantCommand implements Serializable {
	@TargetAggregateIdentifier
	private TenantId id;
	private TenantName name;
	private TenantDescription description;
	private TenantDomain domain;
	private TenantLanguage language;
	private TenantActive active;
	private TenantCreatedBy createdBy;


}
