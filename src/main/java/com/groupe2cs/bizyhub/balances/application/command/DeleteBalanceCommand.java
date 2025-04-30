package com.groupe2cs.bizyhub.balances.application.command;

import com.groupe2cs.bizyhub.balances.domain.valueObject.BalanceId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteBalanceCommand implements Serializable {
	@TargetAggregateIdentifier
	private BalanceId id;


}
