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
public class CreateRefreshTokenCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private RefreshTokenId id = RefreshTokenId.create(UUID.randomUUID().toString());
        private RefreshTokenToken token;
        private RefreshTokenUsername username;
        private RefreshTokenExpiration expiration;
        private RefreshTokenCreatedBy createdBy;
        private RefreshTokenTenant tenant;
	public CreateRefreshTokenCommand(
 
   RefreshTokenToken token , 
   RefreshTokenUsername username , 
   RefreshTokenExpiration expiration , 
   RefreshTokenCreatedBy createdBy , 
   RefreshTokenTenant tenant  
		){
			this.id = RefreshTokenId.create(UUID.randomUUID().toString());
 
  this.token = token ; 
  this.username = username ; 
  this.expiration = expiration ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
