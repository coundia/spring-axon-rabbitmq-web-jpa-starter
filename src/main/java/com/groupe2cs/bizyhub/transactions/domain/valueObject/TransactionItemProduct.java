package com.groupe2cs.bizyhub.transactions.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemIdNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemTransactionNotValid;
import com.groupe2cs.bizyhub.transactions.domain.exception.TransactionItemProductNotValid;

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
public class TransactionItemProduct implements Serializable {

private String product;

public TransactionItemProduct(String product) {
this.product = product;
}

public static TransactionItemProduct create(String product) {

	return new TransactionItemProduct(product);
}

public String value() {
return this.product;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof TransactionItemProduct that)) return false;
return this.product.equals(that.product);
}

@Override
public int hashCode() {
return java.util.Objects.hash(product);
}

@Override
public String toString() {
return String.valueOf(product);
}
}
