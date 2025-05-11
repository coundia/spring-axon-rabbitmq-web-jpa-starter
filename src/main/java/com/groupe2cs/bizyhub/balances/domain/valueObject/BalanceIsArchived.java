package com.groupe2cs.bizyhub.balances.domain.valueObject;

import java.util.Objects;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIdNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceNameNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrencyNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceCurrentBalanceNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalancePreviousBalanceNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceLastUpdatedNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsDefaultNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceOrdreNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsArchivedNotValid;

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
public class BalanceIsArchived implements Serializable {

private Boolean isArchived;

public BalanceIsArchived(Boolean isArchived) {
this.isArchived = isArchived;
}

public static BalanceIsArchived create(Boolean isArchived) {

if (isArchived == null) {
throw new BalanceIsArchivedNotValid("IsArchived is invalid");
}
return new BalanceIsArchived(isArchived);
}

public Boolean value() {
return this.isArchived;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceIsArchived that)) return false;
return this.isArchived.equals(that.isArchived);
}

@Override
public int hashCode() {
return java.util.Objects.hash(isArchived);
}

@Override
public String toString() {
return String.valueOf(isArchived);
}
}
