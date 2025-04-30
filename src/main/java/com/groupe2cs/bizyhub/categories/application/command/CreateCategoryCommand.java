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
	private CategoryTypeCategory typeCategory;
	private CategoryParentId parentId;
	private CategoryIsDefault isDefault;
	private CategoryIcon icon;
	private CategoryColorHex colorHex;
	private CategoryCreatedBy createdBy;
	private CategoryTenant tenant;

	public CreateCategoryCommand(

			CategoryName name,
			CategoryTypeCategory typeCategory,
			CategoryParentId parentId,
			CategoryIsDefault isDefault,
			CategoryIcon icon,
			CategoryColorHex colorHex,
			CategoryCreatedBy createdBy,
			CategoryTenant tenant
	) {
		this.id = CategoryId.create(UUID.randomUUID().toString());

		this.name = name;
		this.typeCategory = typeCategory;
		this.parentId = parentId;
		this.isDefault = isDefault;
		this.icon = icon;
		this.colorHex = colorHex;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
