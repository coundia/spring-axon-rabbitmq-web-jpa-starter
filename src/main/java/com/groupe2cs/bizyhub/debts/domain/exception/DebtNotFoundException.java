package com.groupe2cs.bizyhub.debts.domain.exception;

import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtId;

public class DebtNotFoundException extends RuntimeException {

public DebtNotFoundException(String object, String value) {
super("Debt with "+object+": '" + value + "' not found");
}
}
