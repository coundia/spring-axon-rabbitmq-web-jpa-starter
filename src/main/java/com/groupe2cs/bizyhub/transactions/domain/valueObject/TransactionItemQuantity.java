package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemLabelNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemQuantityNotValid;

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
public class TransactionItemQuantity implements Serializable {

private Integer quantity;

public TransactionItemQuantity(Integer quantity) {
this.quantity = quantity;
}

public static TransactionItemQuantity create(Integer quantity) {

if (quantity < 0) {
throw new TransactionItemQuantityNotValid("Quantity is invalid");
}
return new TransactionItemQuantity(quantity);
}

public Integer value() {
return this.quantity;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemQuantity that)) return false;
return this.quantity.equals(that.quantity);
}

@Override
public int hashCode() {
return java.util.Objects.hash(quantity);
}

@Override
public String toString() {
return String.valueOf(quantity);
}
}
