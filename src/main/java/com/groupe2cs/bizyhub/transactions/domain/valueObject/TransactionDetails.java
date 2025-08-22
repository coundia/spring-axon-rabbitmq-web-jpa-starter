package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDetailsNotValid;

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
public class TransactionDetails implements Serializable {

private String details;

public TransactionDetails(String details) {
this.details = details;
}

public static TransactionDetails create(String details) {

	return new TransactionDetails(details);
}

public String value() {
return this.details;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionDetails that)) return false;
return this.details.equals(that.details);
}

@Override
public int hashCode() {
return java.util.Objects.hash(details);
}

@Override
public String toString() {
return String.valueOf(details);
}
}
