package com.groupe2cs.bizyhub.sales.application.command;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

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
public class CreateSaleUserCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private SaleUserId id = SaleUserId.create(UUID.randomUUID().toString());
 	private SaleUserName name;
 	private SaleUserSales sales;
 	private SaleUserUsers users;
 	private SaleUserUsername username;
 	private SaleUserDetails details;
 	private SaleUserIsActive isActive;
 	private SaleUserUpdatedAt updatedAt;
 	private SaleUserReference reference;
 	private SaleUserCreatedBy createdBy;
 	private SaleUserTenant tenant;
	public CreateSaleUserCommand(
 
   SaleUserName name , 
   SaleUserSales sales , 
   SaleUserUsers users , 
   SaleUserUsername username , 
   SaleUserDetails details , 
   SaleUserIsActive isActive , 
   SaleUserUpdatedAt updatedAt , 
   SaleUserReference reference , 
   SaleUserCreatedBy createdBy , 
   SaleUserTenant tenant  
		){
			this.id = SaleUserId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.sales = sales ; 
  this.users = users ; 
  this.username = username ; 
  this.details = details ; 
  this.isActive = isActive ; 
  this.updatedAt = updatedAt ; 
  this.reference = reference ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
