package com.groupe2cs.bizyhub.categories.application.command;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

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
	private CategoryUpdatedAt updatedAt;
	private CategoryReference reference;
	private CategoryCreatedBy createdBy;
	private CategoryTenant tenant;

	public CreateCategoryCommand(

			CategoryName name,
			CategoryTypeCategoryRaw typeCategoryRaw,
			CategoryDetails details,
			CategoryIsActive isActive,
			CategoryUpdatedAt updatedAt,
			CategoryReference reference,
			CategoryCreatedBy createdBy,
			CategoryTenant tenant
	) {
		this.id = CategoryId.create(UUID.randomUUID().toString());

		this.name = name;
		this.typeCategoryRaw = typeCategoryRaw;
		this.details = details;
		this.isActive = isActive;
		this.updatedAt = updatedAt;
		this.reference = reference;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
