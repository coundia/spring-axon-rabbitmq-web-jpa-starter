package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryReferenceNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryUpdatedAtNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryNotValid;

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
public class CategoryTypeCategory implements Serializable {

private String typeCategory;

public CategoryTypeCategory(String typeCategory) {
this.typeCategory = typeCategory;
}

public static CategoryTypeCategory create(String typeCategory) {

	return new CategoryTypeCategory(typeCategory);
}

public String value() {
return this.typeCategory;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryTypeCategory that)) return false;
return this.typeCategory.equals(that.typeCategory);
}

@Override
public int hashCode() {
return java.util.Objects.hash(typeCategory);
}

@Override
public String toString() {
return String.valueOf(typeCategory);
}
}
