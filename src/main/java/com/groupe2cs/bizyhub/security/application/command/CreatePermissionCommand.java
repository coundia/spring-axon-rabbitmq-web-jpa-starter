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
public class CreatePermissionCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private PermissionId id = PermissionId.create(UUID.randomUUID().toString());
        private PermissionName name;
        private PermissionCreatedBy createdBy;
        private PermissionTenant tenant;
	public CreatePermissionCommand(
 
   PermissionName name , 
   PermissionCreatedBy createdBy , 
   PermissionTenant tenant  
		){
			this.id = PermissionId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
