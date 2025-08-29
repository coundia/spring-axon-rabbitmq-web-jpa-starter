package com.groupe2cs.bizyhub.security.domain.event;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCodeUpdatedEvent implements Serializable {

	private VerificationCodeId id;
	private VerificationCodeNotes notes;
	private VerificationCodeToken token;
	private VerificationCodeUsername username;
	private VerificationCodePhone phone;
	private VerificationCodeEmail email;
	private VerificationCodeCode code;
	private VerificationCodeStatus status;
	private VerificationCodeSource source;
	private VerificationCodeExpiration expiration;
	private VerificationCodeCreatedBy createdBy;
	private VerificationCodeTenant tenant;


}
