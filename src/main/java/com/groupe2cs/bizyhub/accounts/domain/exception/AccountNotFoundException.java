package com.groupe2cs.bizyhub.accounts.domain.exception;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.AccountId;

public class AccountNotFoundException extends RuntimeException {

public AccountNotFoundException(String object, String value) {
super("Account with "+object+": '" + value + "' not found");
}
}
