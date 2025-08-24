package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryCodeNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryRemoteIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryLocalIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryDescriptionNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeEntryNotValid;

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
public class CategoryTypeEntry implements Serializable {

private String typeEntry;

public CategoryTypeEntry(String typeEntry) {
this.typeEntry = typeEntry;
}

public static CategoryTypeEntry create(String typeEntry) {

	return new CategoryTypeEntry(typeEntry);
}

public String value() {
return this.typeEntry;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryTypeEntry that)) return false;
return this.typeEntry.equals(that.typeEntry);
}

@Override
public int hashCode() {
return java.util.Objects.hash(typeEntry);
}

@Override
public String toString() {
return String.valueOf(typeEntry);
}
}
