package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryNameNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryTypeCategoryRawNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryDetailsNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIsActiveNotValid;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryFilesNotValid;

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
public class CategoryFiles implements Serializable {

private String files;

public CategoryFiles(String files) {
this.files = files;
}

public static CategoryFiles create(String files) {

if (files == null || files.isBlank()) {
throw new CategoryFilesNotValid("Files is invalid");
}
return new CategoryFiles(files);
}

public String value() {
return this.files;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryFiles that)) return false;
return this.files.equals(that.files);
}

@Override
public int hashCode() {
return java.util.Objects.hash(files);
}

@Override
public String toString() {
return String.valueOf(files);
}
}
