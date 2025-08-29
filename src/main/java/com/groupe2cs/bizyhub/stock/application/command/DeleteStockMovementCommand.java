package com.groupe2cs.bizyhub.stock.application.command;

import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteStockMovementCommand implements Serializable {
	@TargetAggregateIdentifier
	private StockMovementId id;


}
