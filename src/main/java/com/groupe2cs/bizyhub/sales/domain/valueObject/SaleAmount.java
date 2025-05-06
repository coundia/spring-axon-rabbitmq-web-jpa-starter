package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAmountNotValid;

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
public class SaleAmount implements Serializable {

private Double amount;

public SaleAmount(Double amount) {
this.amount = amount;
}

public static SaleAmount create(Double amount) {

if (amount == null) {
throw new SaleAmountNotValid("Amount is invalid");
}
return new SaleAmount(amount);
}

public Double value() {
return this.amount;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleAmount that)) return false;
return this.amount.equals(that.amount);
}

@Override
public int hashCode() {
return java.util.Objects.hash(amount);
}

@Override
public String toString() {
return String.valueOf(amount);
}
}
