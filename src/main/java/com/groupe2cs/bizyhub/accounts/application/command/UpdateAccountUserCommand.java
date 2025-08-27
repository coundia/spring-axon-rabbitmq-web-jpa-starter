package com.groupe2cs.bizyhub.accounts.application.command;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import java.util.Date;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.util.UUID;


import java.time.*;
import java.util.*;

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
