package com.groupe2cs.bizyhub.categories.domain.event;

import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDeletedEvent implements Serializable {


	private CategoryId id;

}
