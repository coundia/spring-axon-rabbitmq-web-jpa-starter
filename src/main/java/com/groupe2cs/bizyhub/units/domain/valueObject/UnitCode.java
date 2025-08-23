package com.groupe2cs.bizyhub.units.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.units.domain.exception.UnitIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitRemoteIdNotValid;
import com.groupe2cs.bizyhub.units.domain.exception.UnitCodeNotValid;

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
public class UnitCode implements Serializable {

private String code;

public UnitCode(String code) {
this.code = code;
}

public static UnitCode create(String code) {

if (code == null || code.isBlank()) {
throw new UnitCodeNotValid("Code is invalid");
}
return new UnitCode(code);
}

public String value() {
return this.code;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof UnitCode that)) return false;
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
