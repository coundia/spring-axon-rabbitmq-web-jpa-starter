package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryAmountNotValid;

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
public class TransactionEntryAmount implements Serializable {

private Double amount;

public TransactionEntryAmount(Double amount) {
this.amount = amount;
}

public static TransactionEntryAmount create(Double amount) {

if (amount == null) {
throw new TransactionEntryAmountNotValid("Amount is invalid");
}
return new TransactionEntryAmount(amount);
}

public Double value() {
return this.amount;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionEntryAmount that)) return false;
return this.amount.equals(that.amount);
}

@Override
public int hashCode() {
return java.util.Objects.hash(amount);
}

@Override
public String toString() {
return String.valueOf(amount);
}
}
