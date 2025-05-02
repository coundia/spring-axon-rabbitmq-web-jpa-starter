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
public class CreateApiKeyCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private ApiKeyId id = ApiKeyId.create(UUID.randomUUID().toString());
 	private ApiKeyAppKey appKey;
 	private ApiKeyUsername username;
 	private ApiKeyActive active;
 	private ApiKeyCreatedAt createdAt;
 	private ApiKeyExpiration expiration;
 	private ApiKeyCreatedBy createdBy;
 	private ApiKeyTenant tenant;
	public CreateApiKeyCommand(
 
   ApiKeyAppKey appKey , 
   ApiKeyUsername username , 
   ApiKeyActive active , 
   ApiKeyCreatedAt createdAt , 
   ApiKeyExpiration expiration , 
   ApiKeyCreatedBy createdBy , 
   ApiKeyTenant tenant  
		){
			this.id = ApiKeyId.create(UUID.randomUUID().toString());
 
  this.appKey = appKey ; 
  this.username = username ; 
  this.active = active ; 
  this.createdAt = createdAt ; 
  this.expiration = expiration ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
