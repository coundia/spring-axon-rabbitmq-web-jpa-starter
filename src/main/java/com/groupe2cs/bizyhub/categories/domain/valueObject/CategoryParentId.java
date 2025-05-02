package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryReferenceNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryUpdatedAtNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryParentIdNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class CategoryParentId implements Serializable {

private String parentId;

public CategoryParentId(String parentId) {
this.parentId = parentId;
}

public static CategoryParentId create(String parentId) {

	return new CategoryParentId(parentId);
}

public String value() {
return this.parentId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryParentId that)) return false;
return this.parentId.equals(that.parentId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(parentId);
}

@Override
public String toString() {
return String.valueOf(parentId);
}
}
