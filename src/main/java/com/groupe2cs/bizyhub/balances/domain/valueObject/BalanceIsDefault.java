package com.groupe2cs.bizyhub.balances.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIdNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceNameNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrencyNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrentBalanceNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalancePreviousBalanceNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceLastUpdatedNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsDefaultNotValid;

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
public class BalanceIsDefault implements Serializable {

private Boolean isDefault;

public BalanceIsDefault(Boolean isDefault) {
this.isDefault = isDefault;
}

public static BalanceIsDefault create(Boolean isDefault) {

if (isDefault == null) {
throw new BalanceIsDefaultNotValid("IsDefault is invalid");
}
return new BalanceIsDefault(isDefault);
}

public Boolean value() {
return this.isDefault;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceIsDefault that)) return false;
return this.isDefault.equals(that.isDefault);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isDefault);
}

@Override
public String toString() {
return String.valueOf(isDefault);
}
}
