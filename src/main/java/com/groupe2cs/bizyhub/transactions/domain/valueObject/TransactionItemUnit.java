package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitNotValid;

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
public class TransactionItemUnit implements Serializable {

private String unit;

public TransactionItemUnit(String unit) {
this.unit = unit;
}

public static TransactionItemUnit create(String unit) {

	return new TransactionItemUnit(unit);
}

public String value() {
return this.unit;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemUnit that)) return false;
return this.unit.equals(that.unit);
}

@Override
public int hashCode() {
return java.util.Objects.hash(unit);
}

@Override
public String toString() {
return String.valueOf(unit);
}
}
