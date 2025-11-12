package com.groupe2cs.bizyhub.companies.application.command;

import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCompanyCommand implements Serializable {
	@TargetAggregateIdentifier
	private CompanyId id;


}
