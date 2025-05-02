package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryReferenceNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryUpdatedAtNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryParentIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIsDefaultNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIconNotValid;

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
public class CategoryIcon implements Serializable {

private String icon;

public CategoryIcon(String icon) {
this.icon = icon;
}

public static CategoryIcon create(String icon) {

	return new CategoryIcon(icon);
}

public String value() {
return this.icon;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryIcon that)) return false;
return this.icon.equals(that.icon);
}

@Override
public int hashCode() {
return java.util.Objects.hash(icon);
}

@Override
public String toString() {
return String.valueOf(icon);
}
}
