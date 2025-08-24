package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionRemoteIdNotValid;

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
public class TransactionRemoteId implements Serializable {

private String remoteId;

public TransactionRemoteId(String remoteId) {
this.remoteId = remoteId;
}

public static TransactionRemoteId create(String remoteId) {

	return new TransactionRemoteId(remoteId);
}

public String value() {
return this.remoteId;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionRemoteId that)) return false;
return this.remoteId.equals(that.remoteId);
}

@Override
public int hashCode() {
return java.util.Objects.hash(remoteId);
}

@Override
public String toString() {
return String.valueOf(remoteId);
}
}
