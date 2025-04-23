package com.groupe2cs.bizyhub.security.domain.exception;

public class RefreshTokenExpirationNotValid extends RuntimeException {
public RefreshTokenExpirationNotValid(String message) {
super(message);
}
}
