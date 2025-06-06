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
public class CategoryCreatedEvent implements Serializable {

	private CategoryId id;
	private CategoryName name;
	private CategoryTypeCategoryRaw typeCategoryRaw;
	private CategoryDetails details;
	private CategoryIsActive isActive;
	private CategoryCreatedBy createdBy;
	private CategoryTenant tenant;


}
