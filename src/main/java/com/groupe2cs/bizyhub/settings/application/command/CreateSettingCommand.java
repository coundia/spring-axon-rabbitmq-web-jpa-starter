package com.groupe2cs.bizyhub.settings.application.command;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;

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
public class CreateSettingCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private SettingId id = SettingId.create(UUID.randomUUID().toString());
 	private SettingName name;
 	private SettingValue value;
 	private SettingLocale locale;
 	private SettingRemoteId remoteId;
 	private SettingLocalId localId;
 	private SettingAccount account;
 	private SettingDetails details;
 	private SettingSyncAt syncAt;
 	private SettingIsActive isActive;
 	private SettingCreatedBy createdBy;
 	private SettingTenant tenant;
	public CreateSettingCommand(
 
   SettingName name , 
   SettingValue value , 
   SettingLocale locale , 
   SettingRemoteId remoteId , 
   SettingLocalId localId , 
   SettingAccount account , 
   SettingDetails details , 
   SettingSyncAt syncAt , 
   SettingIsActive isActive , 
   SettingCreatedBy createdBy , 
   SettingTenant tenant  
		){
			this.id = SettingId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.value = value ; 
  this.locale = locale ; 
  this.remoteId = remoteId ; 
  this.localId = localId ; 
  this.account = account ; 
  this.details = details ; 
  this.syncAt = syncAt ; 
  this.isActive = isActive ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
