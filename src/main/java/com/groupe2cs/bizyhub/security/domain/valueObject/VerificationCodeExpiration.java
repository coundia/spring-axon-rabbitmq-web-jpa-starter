package com.groupe2cs.bizyhub.security.domain.valueObject;

import java.util.Objects;

import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeIdNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeNotesNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeTokenNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeUsernameNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodePhoneNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeEmailNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeCodeNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeStatusNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeSourceNotValid;
import com.groupe2cs.bizyhub.security.domain.exception.VerificationCodeExpirationNotValid;

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
public class VerificationCodeExpiration implements Serializable {

	private java.time.Instant expiration;

	public VerificationCodeExpiration(java.time.Instant expiration) {
		this.expiration = expiration;
	}

	public static VerificationCodeExpiration create(java.time.Instant expiration) {

		return new VerificationCodeExpiration(expiration);
	}

	public java.time.Instant value() {
		return this.expiration;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof VerificationCodeExpiration that)) return false;
		return this.expiration.equals(that.expiration);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(expiration);
	}

	@Override
	public String toString() {
		return String.valueOf(expiration);
	}
}
