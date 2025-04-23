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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateApiKeyCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private ApiKeyId id = ApiKeyId.create(UUID.randomUUID().toString());
 	private ApiKeyKey key;
 	private ApiKeyUsername username;
 	private ApiKeyCreatedAt createdAt;
 	private ApiKeyExpiration expiration;
	public CreateApiKeyCommand(
 
   ApiKeyKey key , 
   ApiKeyUsername username , 
   ApiKeyCreatedAt createdAt , 
   ApiKeyExpiration expiration  
		){
			this.id = ApiKeyId.create(UUID.randomUUID().toString());
 
  this.key = key ; 
  this.username = username ; 
  this.createdAt = createdAt ; 
  this.expiration = expiration ; 
	}


}
