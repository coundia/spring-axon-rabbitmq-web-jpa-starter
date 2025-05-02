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
 	private CategoryReference reference;
 	private CategoryName name;
 	private CategoryUpdatedAt updatedAt;
 	private CategoryTypeCategory typeCategory;
 	private CategoryParentId parentId;
 	private CategoryIsDefault isDefault;
 	private CategoryIcon icon;
 	private CategoryColorHex colorHex;
 	private CategoryCreatedBy createdBy;
 	private CategoryTenant tenant;
	public CreateCategoryCommand(
 
   CategoryReference reference , 
   CategoryName name , 
   CategoryUpdatedAt updatedAt , 
   CategoryTypeCategory typeCategory , 
   CategoryParentId parentId , 
   CategoryIsDefault isDefault , 
   CategoryIcon icon , 
   CategoryColorHex colorHex , 
   CategoryCreatedBy createdBy , 
   CategoryTenant tenant  
		){
			this.id = CategoryId.create(UUID.randomUUID().toString());
 
  this.reference = reference ; 
  this.name = name ; 
  this.updatedAt = updatedAt ; 
  this.typeCategory = typeCategory ; 
  this.parentId = parentId ; 
  this.isDefault = isDefault ; 
  this.icon = icon ; 
  this.colorHex = colorHex ; 
  this.createdBy = createdBy ; 
  this.tenant = tenant ; 
	}


}
