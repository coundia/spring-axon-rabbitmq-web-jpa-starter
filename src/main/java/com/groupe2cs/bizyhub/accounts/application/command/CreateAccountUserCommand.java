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
 	private AccountUserName name;
 	private AccountUserAccount account;
 	private AccountUserUser user;
 	private AccountUserSyncAt syncAt;
 	private AccountUserUsername username;
 	private AccountUserDetails details;
 	private AccountUserIsActive isActive;
 	private AccountUserCreatedBy createdBy;
 	private AccountUserTenant tenant;
	public CreateAccountUserCommand(
 
   AccountUserName name , 
   AccountUserAccount account , 
   AccountUserUser user , 
   AccountUserSyncAt syncAt , 
   AccountUserUsername username , 
   AccountUserDetails details , 
   AccountUserIsActive isActive , 
   AccountUserCreatedBy createdBy , 
   AccountUserTenant tenant  
		){
			this.id = AccountUserId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.account = account ; 
  this.user = user ; 
  this.syncAt = syncAt ; 
  this.username = username ; 
  this.details = details ; 
  this.isActive = isActive ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
