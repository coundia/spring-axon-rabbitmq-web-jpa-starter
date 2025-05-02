package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyAppKeyNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyActiveNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyCreatedAtNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyExpirationNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyCreatedByNotValid;

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
public class ApiKeyCreatedBy implements Serializable {

private String createdBy;

public ApiKeyCreatedBy(String createdBy) {
this.createdBy = createdBy;
}

public static ApiKeyCreatedBy create(String createdBy) {

	return new ApiKeyCreatedBy(createdBy);
}

public String value() {
return this.createdBy;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ApiKeyCreatedBy that)) return false;
return this.createdBy.equals(that.createdBy);
}

@Override
public int hashCode() {
return java.util.Objects.hash(createdBy);
}

@Override
public String toString() {
return String.valueOf(createdBy);
}
}
