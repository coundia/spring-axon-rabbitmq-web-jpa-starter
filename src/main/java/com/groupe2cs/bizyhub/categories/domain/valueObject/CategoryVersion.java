package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryCodeNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryRemoteIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryDescriptionNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeEntryNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryVersionNotValid;

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
public class CategoryVersion implements Serializable {

private Integer version;

public CategoryVersion(Integer version) {
this.version = version;
}

public static CategoryVersion create(Integer version) {

	return new CategoryVersion(version);
}

public Integer value() {
return this.version;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryVersion that)) return false;
return this.version.equals(that.version);
}

@Override
public int hashCode() {
return java.util.Objects.hash(version);
}

@Override
public String toString() {
return String.valueOf(version);
}
}
