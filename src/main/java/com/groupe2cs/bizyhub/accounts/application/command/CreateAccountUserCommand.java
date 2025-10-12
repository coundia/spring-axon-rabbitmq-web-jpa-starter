package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountUserCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private AccountUserId id = AccountUserId.create(UUID.randomUUID().toString());
	private AccountUserAccount account;
	private AccountUserUser user;
	private AccountUserIdentity identity;
	private AccountUserPhone phone;
	private AccountUserEmail email;
	private AccountUserRole role;
	private AccountUserStatus status;
	private AccountUserInvitedBy invitedBy;
	private AccountUserSyncAt syncAt;
	private AccountUserAcceptedAt acceptedAt;
	private AccountUserRevokedAt revokedAt;
	private AccountUserMessage message;
	private AccountUserRemoteId remoteId;
	private AccountUserLocalId localId;
	private AccountUserIsActive isActive;
	private AccountUserCreatedBy createdBy;
	private AccountUserTenant tenant;

	public CreateAccountUserCommand(

			AccountUserAccount account,
			AccountUserUser user,
			AccountUserIdentity identity,
			AccountUserPhone phone,
			AccountUserEmail email,
			AccountUserRole role,
			AccountUserStatus status,
			AccountUserInvitedBy invitedBy,
			AccountUserSyncAt syncAt,
			AccountUserAcceptedAt acceptedAt,
			AccountUserRevokedAt revokedAt,
			AccountUserMessage message,
			AccountUserRemoteId remoteId,
			AccountUserLocalId localId,
			AccountUserIsActive isActive,
			AccountUserCreatedBy createdBy,
			AccountUserTenant tenant
	) {
		this.id = AccountUserId.create(UUID.randomUUID().toString());

		this.account = account;
		this.user = user;
		this.identity = identity;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.status = status;
		this.invitedBy = invitedBy;
		this.syncAt = syncAt;
		this.acceptedAt = acceptedAt;
		this.revokedAt = revokedAt;
		this.message = message;
		this.remoteId = remoteId;
		this.localId = localId;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
