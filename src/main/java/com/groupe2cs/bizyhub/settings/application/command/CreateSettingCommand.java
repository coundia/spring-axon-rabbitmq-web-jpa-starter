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
 	private SettingStringValue stringValue;
 	private SettingDescription description;
 	private SettingIsActive isActive;
 	private SettingUpdatedAt updatedAt;
 	private SettingReference reference;
 	private SettingCreatedBy createdBy;
 	private SettingTenant tenant;
	public CreateSettingCommand(
 
   SettingName name , 
   SettingStringValue stringValue , 
   SettingDescription description , 
   SettingIsActive isActive , 
   SettingUpdatedAt updatedAt , 
   SettingReference reference , 
   SettingCreatedBy createdBy , 
   SettingTenant tenant  
		){
			this.id = SettingId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.stringValue = stringValue ; 
  this.description = description ; 
  this.isActive = isActive ; 
  this.updatedAt = updatedAt ; 
  this.reference = reference ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
