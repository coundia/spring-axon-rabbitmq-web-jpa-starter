package com.groupe2cs.bizyhub.categories.domain.event;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdatedEvent implements Serializable {

	private CategoryId id;
	private CategoryName name;
	private CategoryTypeCategory typeCategory;
	private CategoryParentId parentId;
	private CategoryIsDefault isDefault;
	private CategoryIcon icon;
	private CategoryColorHex colorHex;
	private CategoryCreatedBy createdBy;
	private CategoryTenant tenant;


}
