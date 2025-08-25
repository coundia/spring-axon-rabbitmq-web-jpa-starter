package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCodeNotValid;

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
public class TransactionCode implements Serializable {

private String code;

public TransactionCode(String code) {
this.code = code;
}

public static TransactionCode create(String code) {

	return new TransactionCode(code);
}

public String value() {
return this.code;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionCode that)) return false;
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
