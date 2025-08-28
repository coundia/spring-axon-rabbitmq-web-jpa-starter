package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemAccountNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemRemoteIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLocalIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemSyncAtNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemUnitPriceNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTotalNotValid;

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
public class TransactionItemTotal implements Serializable {

private Double total;

public TransactionItemTotal(Double total) {
this.total = total;
}

public static TransactionItemTotal create(Double total) {

if (total == null) {
throw new TransactionItemTotalNotValid("Total is invalid");
}
return new TransactionItemTotal(total);
}

public Double value() {
return this.total;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemTotal that)) return false;
return this.total.equals(that.total);
}

@Override
public int hashCode() {
return java.util.Objects.hash(total);
}

@Override
public String toString() {
return String.valueOf(total);
}
}
