package com.groupe2cs.bizyhub.security.domain.exception;

public class PasswordResetExpirationNotValid extends RuntimeException {
public PasswordResetExpirationNotValid(String message) {
super(message);
}
}
