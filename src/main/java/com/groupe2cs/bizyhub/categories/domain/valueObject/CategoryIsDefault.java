package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryReferenceNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryUpdatedAtNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryParentIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIsDefaultNotValid;

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
public class CategoryIsDefault implements Serializable {

private Boolean isDefault;

public CategoryIsDefault(Boolean isDefault) {
this.isDefault = isDefault;
}

public static CategoryIsDefault create(Boolean isDefault) {

	return new CategoryIsDefault(isDefault);
}

public Boolean value() {
return this.isDefault;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryIsDefault that)) return false;
return this.isDefault.equals(that.isDefault);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isDefault);
}

@Override
public String toString() {
return String.valueOf(isDefault);
}
}
