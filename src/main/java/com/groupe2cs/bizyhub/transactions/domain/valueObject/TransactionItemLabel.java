package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;

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
public class TransactionItemLabel implements Serializable {

private String label;

public TransactionItemLabel(String label) {
this.label = label;
}

public static TransactionItemLabel create(String label) {

	return new TransactionItemLabel(label);
}

public String value() {
return this.label;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemLabel that)) return false;
return this.label.equals(that.label);
}

@Override
public int hashCode() {
return java.util.Objects.hash(label);
}

@Override
public String toString() {
return String.valueOf(label);
}
}
