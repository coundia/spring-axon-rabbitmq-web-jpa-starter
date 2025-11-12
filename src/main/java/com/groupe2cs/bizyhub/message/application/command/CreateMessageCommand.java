package com.groupe2cs.bizyhub.message.application.command;

import com.groupe2cs.bizyhub.message.domain.valueObject.*;

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
public class CreateMessageCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private MessageId id = MessageId.create(UUID.randomUUID().toString());
        private MessageCode code;
        private MessageEmail email;
        private MessagePhone phone;
        private MessageContent content;
        private MessagePlateforme plateforme;
        private MessageSource source;
        private MessageAgent agent;
        private MessageStatus status;
        private MessageDescription description;
        private MessageIsActive isActive;
        private MessageIsDefault isDefault;
        private MessageRemoteId remoteId;
        private MessageLocalId localId;
        private MessageDepotAt depotAt;
        private MessageSyncAt syncAt;
        private MessageCreatedBy createdBy;
        private MessageTenant tenant;
	public CreateMessageCommand(
 
   MessageCode code , 
   MessageEmail email , 
   MessagePhone phone , 
   MessageContent content , 
   MessagePlateforme plateforme , 
   MessageSource source , 
   MessageAgent agent , 
   MessageStatus status , 
   MessageDescription description , 
   MessageIsActive isActive , 
   MessageIsDefault isDefault , 
   MessageRemoteId remoteId , 
   MessageLocalId localId , 
   MessageDepotAt depotAt , 
   MessageSyncAt syncAt , 
   MessageCreatedBy createdBy , 
   MessageTenant tenant  
		){
			this.id = MessageId.create(UUID.randomUUID().toString());
 
  this.code = code ; 
  this.email = email ; 
  this.phone = phone ; 
  this.content = content ; 
  this.plateforme = plateforme ; 
  this.source = source ; 
  this.agent = agent ; 
  this.status = status ; 
  this.description = description ; 
  this.isActive = isActive ; 
  this.isDefault = isDefault ; 
  this.remoteId = remoteId ; 
  this.localId = localId ; 
  this.depotAt = depotAt ; 
  this.syncAt = syncAt ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
