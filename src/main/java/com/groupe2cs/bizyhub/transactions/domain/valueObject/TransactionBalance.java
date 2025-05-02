package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDateOperationNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionReferenceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsRecurringNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIsExcluToRapportNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionStatusNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionBalanceNotValid;

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
public class TransactionBalance implements Serializable {

private String balance;

public TransactionBalance(String balance) {
this.balance = balance;
}

public static TransactionBalance create(String balance) {
if (balance == null || balance.isBlank()) {
throw new TransactionBalanceNotValid("Balance is invalid");
}
return new TransactionBalance(balance);
}

public String value() {
return this.balance;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionBalance that)) return false;
return this.balance.equals(that.balance);
}

@Override
public int hashCode() {
return java.util.Objects.hash(balance);
}

@Override
public String toString() {
return String.valueOf(balance);
}
}
