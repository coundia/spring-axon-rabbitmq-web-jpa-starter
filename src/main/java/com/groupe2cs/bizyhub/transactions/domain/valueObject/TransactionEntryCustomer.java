package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryTypeEntryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryDateTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryStatusNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryEntityNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryEntityIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryAccountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntrySyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCategoryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCompanyNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntryCustomerNotValid;

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
public class TransactionEntryCustomer implements Serializable {

private String customer;

public TransactionEntryCustomer(String customer) {
this.customer = customer;
}

public static TransactionEntryCustomer create(String customer) {

	return new TransactionEntryCustomer(customer);
}

public String value() {
return this.customer;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionEntryCustomer that)) return false;
return this.customer.equals(that.customer);
}

@Override
public int hashCode() {
return java.util.Objects.hash(customer);
}

@Override
public String toString() {
return String.valueOf(customer);
}
}
