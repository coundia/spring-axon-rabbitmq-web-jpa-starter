package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryRawNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryDetailsNotValid;

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
public class CategoryDetails implements Serializable {

private String details;

public CategoryDetails(String details) {
this.details = details;
}

public static CategoryDetails create(String details) {

	return new CategoryDetails(details);
}

public String value() {
return this.details;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryDetails that)) return false;
return this.details.equals(that.details);
}

@Override
public int hashCode() {
return java.util.Objects.hash(details);
}

@Override
public String toString() {
return String.valueOf(details);
}
}
