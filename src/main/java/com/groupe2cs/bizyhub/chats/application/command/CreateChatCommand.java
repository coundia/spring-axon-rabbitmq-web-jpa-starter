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
 	private ChatResponsesJson responsesJson;
 	private ChatResponses responses;
 	private ChatState state;
 	private ChatSyncAt syncAt;
 	private ChatRemoteId remoteId;
 	private ChatAccount account;
 	private ChatFiles files;
 	private ChatDateTransaction dateTransaction;
 	private ChatCreatedBy createdBy;
 	private ChatTenant tenant;
	public CreateChatCommand(
 
   ChatMessages messages , 
   ChatResponsesJson responsesJson , 
   ChatResponses responses , 
   ChatState state , 
   ChatSyncAt syncAt , 
   ChatRemoteId remoteId , 
   ChatAccount account , 
   ChatFiles files , 
   ChatDateTransaction dateTransaction , 
   ChatCreatedBy createdBy , 
   ChatTenant tenant  
		){
			this.id = ChatId.create(UUID.randomUUID().toString());
 
  this.messages = messages ; 
  this.responsesJson = responsesJson ; 
  this.responses = responses ; 
  this.state = state ; 
  this.syncAt = syncAt ; 
  this.remoteId = remoteId ; 
  this.account = account ; 
  this.files = files ; 
  this.dateTransaction = dateTransaction ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
