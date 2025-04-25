package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.PasswordResetIdNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class PasswordResetId implements Serializable {

private String id;

public PasswordResetId(String id) {
this.id = id;
}

public static PasswordResetId create(String id) {
if (id == null || id.isBlank()) {
throw new PasswordResetIdNotValid("Id is invalid");
}
return new PasswordResetId(id);
}

public String value() {
return this.id;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof PasswordResetId that)) return false;
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
