package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionsIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionsReferenceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionsAmountNotValid;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionsAmount implements Serializable {

private Double amount;

public TransactionsAmount(Double amount) {
this.amount = amount;
}

public static TransactionsAmount create(Double amount) {
if (amount == null) {
throw new TransactionsAmountNotValid("Amount is invalid");
}
return new TransactionsAmount(amount);
}

public Double value() {
return this.amount;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionsAmount that)) return false;
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
