package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryCodeNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryRemoteIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryLocalIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryAccountNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryStatusNotValid;

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
public class CategoryStatus implements Serializable {

private String status;

public CategoryStatus(String status) {
this.status = status;
}

public static CategoryStatus create(String status) {

	return new CategoryStatus(status);
}

public String value() {
return this.status;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryStatus that)) return false;
return this.status.equals(that.status);
}

@Override
public int hashCode() {
return java.util.Objects.hash(status);
}

@Override
public String toString() {
return String.valueOf(status);
}
}
