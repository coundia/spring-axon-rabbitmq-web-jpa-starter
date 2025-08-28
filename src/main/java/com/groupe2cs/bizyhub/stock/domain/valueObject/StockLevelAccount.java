package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelLocalIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockOnHandNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockAllocatedNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelAccountNotValid;

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
public class StockLevelAccount implements Serializable {

private String account;

public StockLevelAccount(String account) {
this.account = account;
}

public static StockLevelAccount create(String account) {

	return new StockLevelAccount(account);
}

public String value() {
return this.account;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelAccount that)) return false;
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
