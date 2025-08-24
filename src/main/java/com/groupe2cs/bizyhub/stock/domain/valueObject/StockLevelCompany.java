package com.groupe2cs.bizyhub.stock.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelRemoteIdNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockOnHandNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelStockAllocatedNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelProductVariantNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelSyncAtNotValid;
import com.groupe2cs.bizyhub.stock.domain.exception.StockLevelCompanyNotValid;

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
public class StockLevelCompany implements Serializable {

private String company;

public StockLevelCompany(String company) {
this.company = company;
}

public static StockLevelCompany create(String company) {

if (company == null || company.isBlank()) {
throw new StockLevelCompanyNotValid("Company is invalid");
}
return new StockLevelCompany(company);
}

public String value() {
return this.company;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof StockLevelCompany that)) return false;
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
