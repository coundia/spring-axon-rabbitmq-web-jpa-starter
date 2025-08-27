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
public class CreateAccountUserCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private AccountUserId id = AccountUserId.create(UUID.randomUUID().toString());
 	private AccountUserAccount account;
 	private AccountUserUser user;
 	private AccountUserPhone phone;
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
 
   AccountUserAccount account , 
   AccountUserUser user , 
   AccountUserPhone phone , 
   AccountUserRole role , 
   AccountUserStatus status , 
   AccountUserInvitedBy invitedBy , 
   AccountUserSyncAt syncAt , 
   AccountUserAcceptedAt acceptedAt , 
   AccountUserRevokedAt revokedAt , 
   AccountUserMessage message , 
   AccountUserRemoteId remoteId , 
   AccountUserLocalId localId , 
   AccountUserIsActive isActive , 
   AccountUserCreatedBy createdBy , 
   AccountUserTenant tenant  
		){
			this.id = AccountUserId.create(UUID.randomUUID().toString());
 
  this.account = account ; 
  this.user = user ; 
  this.phone = phone ; 
  this.role = role ; 
  this.status = status ; 
  this.invitedBy = invitedBy ; 
  this.syncAt = syncAt ; 
  this.acceptedAt = acceptedAt ; 
  this.revokedAt = revokedAt ; 
  this.message = message ; 
  this.remoteId = remoteId ; 
  this.localId = localId ; 
  this.isActive = isActive ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
