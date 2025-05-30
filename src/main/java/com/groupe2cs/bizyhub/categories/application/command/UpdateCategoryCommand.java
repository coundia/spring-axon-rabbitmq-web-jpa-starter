package com.groupe2cs.bizyhub.categories.application.command;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCategoryCommand implements Serializable {
	@TargetAggregateIdentifier
	private CategoryId id;
	private CategoryName name;
	private CategoryTypeCategoryRaw typeCategoryRaw;
	private CategoryDetails details;
	private CategoryIsActive isActive;
	private CategoryCreatedBy createdBy;
	private CategoryTenant tenant;


}
