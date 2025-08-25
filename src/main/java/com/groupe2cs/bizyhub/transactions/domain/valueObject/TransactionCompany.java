package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCodeNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDescriptionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAmountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionTypeEntryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionDateTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionStatusNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntityNameNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionEntityIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionAccountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCategoryNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionCompanyNotValid;

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
public class TransactionCompany implements Serializable {

private String company;

public TransactionCompany(String company) {
this.company = company;
}

public static TransactionCompany create(String company) {

	return new TransactionCompany(company);
}

public String value() {
return this.company;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionCompany that)) return false;
return this.company.equals(that.company);
}

@Override
public int hashCode() {
return java.util.Objects.hash(company);
}

@Override
public String toString() {
return String.valueOf(company);
}
}
