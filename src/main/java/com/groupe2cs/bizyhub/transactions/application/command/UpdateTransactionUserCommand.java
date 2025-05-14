package com.groupe2cs.bizyhub.transactions.application.command;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTransactionUserCommand implements Serializable {
	@TargetAggregateIdentifier
	private TransactionUserId id;
	private TransactionUserName name;
	private TransactionUserTransaction transaction;
	private TransactionUserUser user;
	private TransactionUserUsername username;
	private TransactionUserDetails details;
	private TransactionUserIsActive isActive;
	private TransactionUserUpdatedAt updatedAt;
	private TransactionUserReference reference;
	private TransactionUserCreatedBy createdBy;
	private TransactionUserTenant tenant;


}
