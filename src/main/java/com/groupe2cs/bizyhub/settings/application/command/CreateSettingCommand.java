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
 	private SettingReference reference;
 	private SettingUpdatedAt updatedAt;
 	private SettingStringValue stringValue;
 	private SettingDescriptions descriptions;
 	private SettingIsActive isActive;
 	private SettingCreatedBy createdBy;
 	private SettingTenant tenant;
	public CreateSettingCommand(
 
   SettingName name , 
   SettingReference reference , 
   SettingUpdatedAt updatedAt , 
   SettingStringValue stringValue , 
   SettingDescriptions descriptions , 
   SettingIsActive isActive , 
   SettingCreatedBy createdBy , 
   SettingTenant tenant  
		){
			this.id = SettingId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.reference = reference ; 
  this.updatedAt = updatedAt ; 
  this.stringValue = stringValue ; 
  this.descriptions = descriptions ; 
  this.isActive = isActive ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
