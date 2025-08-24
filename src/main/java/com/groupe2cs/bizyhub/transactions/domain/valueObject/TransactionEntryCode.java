package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCodeNotValid;

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
public class TransactionEntryCode implements Serializable {

private String code;

public TransactionEntryCode(String code) {
this.code = code;
}

public static TransactionEntryCode create(String code) {

	return new TransactionEntryCode(code);
}

public String value() {
return this.code;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionEntryCode that)) return false;
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
