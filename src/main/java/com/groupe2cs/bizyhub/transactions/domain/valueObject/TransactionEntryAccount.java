package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryTypeEntryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDateTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryStatusNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryEntityNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryEntityIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryAccountNotValid;

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
public class TransactionEntryAccount implements Serializable {

private String account;

public TransactionEntryAccount(String account) {
this.account = account;
}

public static TransactionEntryAccount create(String account) {

	return new TransactionEntryAccount(account);
}

public String value() {
return this.account;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionEntryAccount that)) return false;
return this.account.equals(that.account);
}

@Override
public int hashCode() {
return java.util.Objects.hash(account);
}

@Override
public String toString() {
return String.valueOf(account);
}
}
