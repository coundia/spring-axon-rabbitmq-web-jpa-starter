package com.groupe2cs.bizyhub.debts.application.command;

import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteDebtCommand implements Serializable {
	@TargetAggregateIdentifier
	private DebtId id;


}
