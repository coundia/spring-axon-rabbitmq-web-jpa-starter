package com.groupe2cs.bizyhub.categories.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.categories.domain.exception.CategoryIdNotValid;

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
public class CategoryId implements Serializable {

private String id;

public CategoryId(String id) {
this.id = id;
}

public static CategoryId create(String id) {

if (id == null || id.isBlank()) {
throw new CategoryIdNotValid("Id is invalid");
}
return new CategoryId(id);
}

public String value() {
return this.id;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CategoryId that)) return false;
return this.id.equals(that.id);
}

@Override
public int hashCode() {
return java.util.Objects.hash(id);
}

@Override
public String toString() {
return String.valueOf(id);
}
}
