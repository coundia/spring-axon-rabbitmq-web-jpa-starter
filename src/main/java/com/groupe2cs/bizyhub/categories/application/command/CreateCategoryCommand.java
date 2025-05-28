package com.groupe2cs.bizyhub.categories.application.command;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;

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
public class CreateCategoryCommand implements Serializable {
@TargetAggregateIdentifier
	@Builder.Default
	private CategoryId id = CategoryId.create(UUID.randomUUID().toString());
 	private CategoryName name;
 	private CategoryTypeCategoryRaw typeCategoryRaw;
 	private CategoryDetails details;
 	private CategoryIsActive isActive;
 	private CategoryCreatedBy createdBy;
 	private CategoryTenant tenant;
	public CreateCategoryCommand(
 
   CategoryName name , 
   CategoryTypeCategoryRaw typeCategoryRaw , 
   CategoryDetails details , 
   CategoryIsActive isActive , 
   CategoryCreatedBy createdBy , 
   CategoryTenant tenant  
		){
			this.id = CategoryId.create(UUID.randomUUID().toString());
 
  this.name = name ; 
  this.typeCategoryRaw = typeCategoryRaw ; 
  this.details = details ; 
  this.isActive = isActive ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
