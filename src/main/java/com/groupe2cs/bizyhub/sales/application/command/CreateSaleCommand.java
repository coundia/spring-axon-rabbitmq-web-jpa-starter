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
public class CreateSaleCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private SaleId id = SaleId.create(UUID.randomUUID().toString());
 	private SaleName name;
 	private SaleAmount amount;
 	private SaleDetails details;
 	private SaleIsActive isActive;
 	private SaleAccount account;
 	private SaleCategory category;
 	private SaleUpdatedAt updatedAt;
 	private SaleReference reference;
 	private SaleCreatedBy createdBy;
 	private SaleTenant tenant;
	public CreateSaleCommand(
 
   SaleName name , 
   SaleAmount amount , 
   SaleDetails details , 
   SaleIsActive isActive , 
   SaleAccount account , 
   SaleCategory category , 
   SaleUpdatedAt updatedAt , 
   SaleReference reference , 
   SaleCreatedBy createdBy , 
   SaleTenant tenant  
		){
			this.id = SaleId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.amount = amount ; 
  this.details = details ; 
  this.isActive = isActive ; 
  this.account = account ; 
  this.category = category ; 
  this.updatedAt = updatedAt ; 
  this.reference = reference ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
