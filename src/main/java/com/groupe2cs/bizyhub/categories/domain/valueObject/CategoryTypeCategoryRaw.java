package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryRawNotValid;

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
public class CategoryTypeCategoryRaw implements Serializable {

private String typeCategoryRaw;

public CategoryTypeCategoryRaw(String typeCategoryRaw) {
this.typeCategoryRaw = typeCategoryRaw;
}

public static CategoryTypeCategoryRaw create(String typeCategoryRaw) {

	return new CategoryTypeCategoryRaw(typeCategoryRaw);
}

public String value() {
return this.typeCategoryRaw;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryTypeCategoryRaw that)) return false;
return this.typeCategoryRaw.equals(that.typeCategoryRaw);
}

@Override
public int hashCode() {
return java.util.Objects.hash(typeCategoryRaw);
}

@Override
public String toString() {
return String.valueOf(typeCategoryRaw);
}
}
