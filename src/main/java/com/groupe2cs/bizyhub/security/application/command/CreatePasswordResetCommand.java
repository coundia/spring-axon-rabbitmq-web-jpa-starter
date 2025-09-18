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
public class CreatePasswordResetCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private PasswordResetId id = PasswordResetId.create(UUID.randomUUID().toString());
        private PasswordResetToken token;
        private PasswordResetUsername username;
        private PasswordResetExpiration expiration;
        private PasswordResetCreatedBy createdBy;
        private PasswordResetTenant tenant;
	public CreatePasswordResetCommand(
 
   PasswordResetToken token , 
   PasswordResetUsername username , 
   PasswordResetExpiration expiration , 
   PasswordResetCreatedBy createdBy , 
   PasswordResetTenant tenant  
		){
			this.id = PasswordResetId.create(UUID.randomUUID().toString());
 
  this.token = token ; 
  this.username = username ; 
  this.expiration = expiration ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
