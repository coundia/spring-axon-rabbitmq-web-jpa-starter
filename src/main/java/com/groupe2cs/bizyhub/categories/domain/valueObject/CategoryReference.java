package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryRawNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryDetailsNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIsActiveNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryUpdatedAtNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryReferenceNotValid;

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
public class CategoryReference implements Serializable {

private String reference;

public CategoryReference(String reference) {
this.reference = reference;
}

public static CategoryReference create(String reference) {

	return new CategoryReference(reference);
}

public String value() {
return this.reference;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryReference that)) return false;
return this.reference.equals(that.reference);
}

@Override
public int hashCode() {
return java.util.Objects.hash(reference);
}

@Override
public String toString() {
return String.valueOf(reference);
}
}
