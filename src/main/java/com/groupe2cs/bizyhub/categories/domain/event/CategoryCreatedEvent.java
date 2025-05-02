package com.groupe2cs.bizyhub.categories.domain.event;

	import com.groupe2cs.bizyhub.categories.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreatedEvent implements Serializable {

	private CategoryId id;
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



}
