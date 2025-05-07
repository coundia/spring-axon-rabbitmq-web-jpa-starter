package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSalesNotValid;

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
public class SaleUserSales implements Serializable {

private String sales;

public SaleUserSales(String sales) {
this.sales = sales;
}

public static SaleUserSales create(String sales) {

	return new SaleUserSales(sales);
}

public String value() {
return this.sales;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserSales that)) return false;
return this.sales.equals(that.sales);
}

@Override
public int hashCode() {
return java.util.Objects.hash(sales);
}

@Override
public String toString() {
return String.valueOf(sales);
}
}
