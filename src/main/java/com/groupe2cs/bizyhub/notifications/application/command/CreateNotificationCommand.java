package com.groupe2cs.bizyhub.notifications.application.command;

import com.groupe2cs.bizyhub.notifications.domain.valueObject.*;

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
public class CreateNotificationCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private NotificationId id = NotificationId.create(UUID.randomUUID().toString());
 	private NotificationDeviceToken deviceToken;
 	private NotificationTitle title;
 	private NotificationMessage message;
 	private NotificationStatus status;
 	private NotificationRemoteId remoteId;
 	private NotificationSyncAt syncAt;
 	private NotificationReserved reserved;
 	private NotificationErrorMessage errorMessage;
 	private NotificationCreatedBy createdBy;
 	private NotificationTenant tenant;
	public CreateNotificationCommand(
 
   NotificationDeviceToken deviceToken , 
   NotificationTitle title , 
   NotificationMessage message , 
   NotificationStatus status , 
   NotificationRemoteId remoteId , 
   NotificationSyncAt syncAt , 
   NotificationReserved reserved , 
   NotificationErrorMessage errorMessage , 
   NotificationCreatedBy createdBy , 
   NotificationTenant tenant  
		){
			this.id = NotificationId.create(UUID.randomUUID().toString());
 
  this.deviceToken = deviceToken ; 
  this.title = title ; 
  this.message = message ; 
  this.status = status ; 
  this.remoteId = remoteId ; 
  this.syncAt = syncAt ; 
  this.reserved = reserved ; 
  this.errorMessage = errorMessage ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
