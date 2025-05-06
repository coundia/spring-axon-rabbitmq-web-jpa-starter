package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.ApiKeyAppKeyNotValid;

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
public class ApiKeyAppKey implements Serializable {

private String appKey;

public ApiKeyAppKey(String appKey) {
this.appKey = appKey;
}

public static ApiKeyAppKey create(String appKey) {

if (appKey == null || appKey.isBlank()) {
throw new ApiKeyAppKeyNotValid("AppKey is invalid");
}
return new ApiKeyAppKey(appKey);
}

public String value() {
return this.appKey;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof ApiKeyAppKey that)) return false;
return this.appKey.equals(that.appKey);
}

@Override
public int hashCode() {
return java.util.Objects.hash(appKey);
}

@Override
public String toString() {
return String.valueOf(appKey);
}
}
