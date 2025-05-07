package com.groupe2cs.bizyhub.products.application.command;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;

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
public class CreateProductCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private ProductId id = ProductId.create(UUID.randomUUID().toString());
 	private ProductName name;
 	private ProductPrice price;
 	private ProductDetails details;
 	private ProductIsActive isActive;
 	private ProductUpdatedAt updatedAt;
 	private ProductReference reference;
 	private ProductCreatedBy createdBy;
 	private ProductTenant tenant;
	public CreateProductCommand(
 
   ProductName name , 
   ProductPrice price , 
   ProductDetails details , 
   ProductIsActive isActive , 
   ProductUpdatedAt updatedAt , 
   ProductReference reference , 
   ProductCreatedBy createdBy , 
   ProductTenant tenant  
		){
			this.id = ProductId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.price = price ; 
  this.details = details ; 
  this.isActive = isActive ; 
  this.updatedAt = updatedAt ; 
  this.reference = reference ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
