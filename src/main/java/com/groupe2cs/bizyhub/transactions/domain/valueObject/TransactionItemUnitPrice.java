package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitPriceNotValid;

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
public class TransactionItemUnitPrice implements Serializable {

private Double unitPrice;

public TransactionItemUnitPrice(Double unitPrice) {
this.unitPrice = unitPrice;
}

public static TransactionItemUnitPrice create(Double unitPrice) {

if (unitPrice == null) {
throw new TransactionItemUnitPriceNotValid("UnitPrice is invalid");
}
return new TransactionItemUnitPrice(unitPrice);
}

public Double value() {
return this.unitPrice;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemUnitPrice that)) return false;
return this.unitPrice.equals(that.unitPrice);
}

@Override
public int hashCode() {
return java.util.Objects.hash(unitPrice);
}

@Override
public String toString() {
return String.valueOf(unitPrice);
}
}
