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
public class CreateRoleCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private RoleId id = RoleId.create(UUID.randomUUID().toString());
 	private RoleName name;
 	private RoleCreatedBy createdBy;
 	private RoleTenant tenant;
	public CreateRoleCommand(
 
   RoleName name , 
   RoleCreatedBy createdBy , 
   RoleTenant tenant  
		){
			this.id = RoleId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
