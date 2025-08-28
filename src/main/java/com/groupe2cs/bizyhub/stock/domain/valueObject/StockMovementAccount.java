package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementTypeStockMovementNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementQuantityNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementLocalIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockMovementAccountNotValid;

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
public class StockMovementAccount implements Serializable {

private String account;

public StockMovementAccount(String account) {
this.account = account;
}

public static StockMovementAccount create(String account) {

	return new StockMovementAccount(account);
}

public String value() {
return this.account;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockMovementAccount that)) return false;
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
