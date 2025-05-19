package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;

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
public class CreateUserCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private UserId id = UserId.create(UUID.randomUUID().toString());
 	private UserUsername username;
 	private UserPassword password;
 	private UserFirstName firstName;
 	private UserLastName lastName;
 	private UserEmail email;
 	private UserTelephone telephone;
 	private UserLimitPerDay limitPerDay;
 	private UserIsPremium isPremium;
 	private UserEnabled enabled;
 	private UserIsBan isBan;
 	private UserCreatedBy createdBy;
 	private UserTenant tenant;
	public CreateUserCommand(
 
   UserUsername username , 
   UserPassword password , 
   UserFirstName firstName , 
   UserLastName lastName , 
   UserEmail email , 
   UserTelephone telephone , 
   UserLimitPerDay limitPerDay , 
   UserIsPremium isPremium , 
   UserEnabled enabled , 
   UserIsBan isBan , 
   UserCreatedBy createdBy , 
   UserTenant tenant  
		){
			this.id = UserId.create(UUID.randomUUID().toString());
 
  this.username = username ; 
  this.password = password ; 
  this.firstName = firstName ; 
  this.lastName = lastName ; 
  this.email = email ; 
  this.telephone = telephone ; 
  this.limitPerDay = limitPerDay ; 
  this.isPremium = isPremium ; 
  this.enabled = enabled ; 
  this.isBan = isBan ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
