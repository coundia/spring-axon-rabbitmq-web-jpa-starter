package com.groupe2cs.bizyhub.tenant.application.command;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteTenantCommand implements Serializable {
	@TargetAggregateIdentifier
	private TenantId id;


}
