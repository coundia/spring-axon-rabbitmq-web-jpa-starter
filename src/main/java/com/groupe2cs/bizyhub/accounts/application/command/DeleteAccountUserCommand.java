package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountUserId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteAccountUserCommand implements Serializable {
	@TargetAggregateIdentifier
	private AccountUserId id;


}
