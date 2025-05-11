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
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsAllowDebitNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsAllowCreditNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceIsExcluTotalNotValid;
import com.groupe2cs.bizyhub.balances.domain.exception.BalanceActivateNotificationNotValid;

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
public class BalanceActivateNotification implements Serializable {

private Boolean activateNotification;

public BalanceActivateNotification(Boolean activateNotification) {
this.activateNotification = activateNotification;
}

public static BalanceActivateNotification create(Boolean activateNotification) {

if (activateNotification == null) {
throw new BalanceActivateNotificationNotValid("ActivateNotification is invalid");
}
return new BalanceActivateNotification(activateNotification);
}

public Boolean value() {
return this.activateNotification;
}

@Override
public boolean equals(Object o) {
if (this == o) return true;
if (!(o instanceof BalanceActivateNotification that)) return false;
return this.activateNotification.equals(that.activateNotification);
}

@Override
public int hashCode() {
return java.util.Objects.hash(activateNotification);
}

@Override
public String toString() {
return String.valueOf(activateNotification);
}
}
