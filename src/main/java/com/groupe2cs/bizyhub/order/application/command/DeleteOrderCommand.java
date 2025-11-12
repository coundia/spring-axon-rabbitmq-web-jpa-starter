package com.groupe2cs.bizyhub.order.application.command;

import com.groupe2cs.bizyhub.order.domain.valueObject.OrderId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteOrderCommand implements Serializable {
	@TargetAggregateIdentifier
	private OrderId id;


}
