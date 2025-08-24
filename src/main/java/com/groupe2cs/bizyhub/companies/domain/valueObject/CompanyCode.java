package com.groupe2cs.bizyhub.companies.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyRemoteIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyLocalIdNotValid;
import com.groupe2cs.bizyhub.companies.domain.exception.CompanyCodeNotValid;

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
public class CompanyCode implements Serializable {

private String code;

public CompanyCode(String code) {
this.code = code;
}

public static CompanyCode create(String code) {

if (code == null || code.isBlank()) {
throw new CompanyCodeNotValid("Code is invalid");
}
return new CompanyCode(code);
}

public String value() {
return this.code;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof CompanyCode that)) return false;
return this.code.equals(that.code);
}

@Override
public int hashCode() {
return java.util.Objects.hash(code);
}

@Override
public String toString() {
return String.valueOf(code);
}
}
