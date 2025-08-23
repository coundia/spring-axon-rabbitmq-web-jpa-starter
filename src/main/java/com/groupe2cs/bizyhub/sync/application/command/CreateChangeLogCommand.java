package com.groupe2cs.bizyhub.sync.application.command;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;

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
public class CreateChangeLogCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private ChangeLogId id = ChangeLogId.create(UUID.randomUUID().toString());
 	private ChangeLogEntityTable entityTable;
 	private ChangeLogEntityId entityId;
 	private ChangeLogOperation operation;
 	private ChangeLogPayload payload;
 	private ChangeLogStatus status;
 	private ChangeLogSyncAt syncAt;
 	private ChangeLogAttempts attempts;
 	private ChangeLogError error;
 	private ChangeLogCreatedBy createdBy;
 	private ChangeLogTenant tenant;
	public CreateChangeLogCommand(
 
   ChangeLogEntityTable entityTable , 
   ChangeLogEntityId entityId , 
   ChangeLogOperation operation , 
   ChangeLogPayload payload , 
   ChangeLogStatus status , 
   ChangeLogSyncAt syncAt , 
   ChangeLogAttempts attempts , 
   ChangeLogError error , 
   ChangeLogCreatedBy createdBy , 
   ChangeLogTenant tenant  
		){
			this.id = ChangeLogId.create(UUID.randomUUID().toString());
 
  this.entityTable = entityTable ; 
  this.entityId = entityId ; 
  this.operation = operation ; 
  this.payload = payload ; 
  this.status = status ; 
  this.syncAt = syncAt ; 
  this.attempts = attempts ; 
  this.error = error ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
