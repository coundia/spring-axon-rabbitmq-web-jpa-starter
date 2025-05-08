package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleUserSaleNotValid;

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
public class SaleUserSale implements Serializable {

private String sale;

public SaleUserSale(String sale) {
this.sale = sale;
}

public static SaleUserSale create(String sale) {

	return new SaleUserSale(sale);
}

public String value() {
return this.sale;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleUserSale that)) return false;
return this.sale.equals(that.sale);
}

@Override
public int hashCode() {
return java.util.Objects.hash(sale);
}

@Override
public String toString() {
return String.valueOf(sale);
}
}
