package com.groupe2cs.bizyhub.chats.application.command;

import com.groupe2cs.bizyhub.chats.domain.valueObject.*;

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
public class CreateChatCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private ChatId id = ChatId.create(UUID.randomUUID().toString());
 	private ChatMessages messages;
 	private ChatResponses responses;
 	private ChatState state;
 	private ChatAccount account;
 	private ChatUpdatedAt updatedAt;
 	private ChatReference reference;
 	private ChatCreatedBy createdBy;
 	private ChatTenant tenant;
	public CreateChatCommand(
 
   ChatMessages messages , 
   ChatResponses responses , 
   ChatState state , 
   ChatAccount account , 
   ChatUpdatedAt updatedAt , 
   ChatReference reference , 
   ChatCreatedBy createdBy , 
   ChatTenant tenant  
		){
			this.id = ChatId.create(UUID.randomUUID().toString());
 
  this.messages = messages ; 
  this.responses = responses ; 
  this.state = state ; 
  this.account = account ; 
  this.updatedAt = updatedAt ; 
  this.reference = reference ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
