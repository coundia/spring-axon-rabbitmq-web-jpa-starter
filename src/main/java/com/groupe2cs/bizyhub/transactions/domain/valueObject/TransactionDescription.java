package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDescriptionNotValid;

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
public class TransactionDescription implements Serializable {

private String description;

public TransactionDescription(String description) {
this.description = description;
}

public static TransactionDescription create(String description) {

	return new TransactionDescription(description);
}

public String value() {
return this.description;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionDescription that)) return false;
return this.description.equals(that.description);
}

@Override
public int hashCode() {
return java.util.Objects.hash(description);
}

@Override
public String toString() {
return String.valueOf(description);
}
}
