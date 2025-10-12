package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAccountUserCommand implements Serializable {
	@TargetAggregateIdentifier
	private AccountUserId id;
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


}
