package com.groupe2cs.bizyhub.transactions.application.command;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTransactionUserCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private TransactionUserId id = TransactionUserId.create(UUID.randomUUID().toString());
	private TransactionUserName name;
	private TransactionUserRemoteId remoteId;
	private TransactionUserLocalId localId;
	private TransactionUserTransaction transaction;
	private TransactionUserUser user;
	private TransactionUserSyncAt syncAt;
	private TransactionUserUsername username;
	private TransactionUserDetails details;
	private TransactionUserIsActive isActive;
	private TransactionUserCreatedBy createdBy;
	private TransactionUserTenant tenant;

	public CreateTransactionUserCommand(

			TransactionUserName name,
			TransactionUserRemoteId remoteId,
			TransactionUserLocalId localId,
			TransactionUserTransaction transaction,
			TransactionUserUser user,
			TransactionUserSyncAt syncAt,
			TransactionUserUsername username,
			TransactionUserDetails details,
			TransactionUserIsActive isActive,
			TransactionUserCreatedBy createdBy,
			TransactionUserTenant tenant
	) {
		this.id = TransactionUserId.create(UUID.randomUUID().toString());

		this.name = name;
		this.remoteId = remoteId;
		this.localId = localId;
		this.transaction = transaction;
		this.user = user;
		this.syncAt = syncAt;
		this.username = username;
		this.details = details;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
