package com.groupe2cs.bizyhub.accounts.domain.event;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountUserUpdatedEvent implements Serializable {

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
