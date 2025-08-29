package com.groupe2cs.bizyhub.customers.application.command;

import com.groupe2cs.bizyhub.customers.domain.valueObject.CustomerId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCustomerCommand implements Serializable {
	@TargetAggregateIdentifier
	private CustomerId id;


}
