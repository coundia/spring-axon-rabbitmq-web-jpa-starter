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
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryColorHexNotValid;

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
public class CategoryColorHex implements Serializable {

private String colorHex;

public CategoryColorHex(String colorHex) {
this.colorHex = colorHex;
}

public static CategoryColorHex create(String colorHex) {

	return new CategoryColorHex(colorHex);
}

public String value() {
return this.colorHex;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryColorHex that)) return false;
return this.colorHex.equals(that.colorHex);
}

@Override
public int hashCode() {
return java.util.Objects.hash(colorHex);
}

@Override
public String toString() {
return String.valueOf(colorHex);
}
}
