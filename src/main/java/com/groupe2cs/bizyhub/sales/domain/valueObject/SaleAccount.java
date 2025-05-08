package com.groupe2cs.bizyhub.sales.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIdNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleNameNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAmountNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleDetailsNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleIsActiveNotValid;
import com.groupe2cs.bizyhub.sales.domain.exception.SaleAccountNotValid;

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
public class SaleAccount implements Serializable {

private String account;

public SaleAccount(String account) {
this.account = account;
}

public static SaleAccount create(String account) {

	return new SaleAccount(account);
}

public String value() {
return this.account;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof SaleAccount that)) return false;
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
