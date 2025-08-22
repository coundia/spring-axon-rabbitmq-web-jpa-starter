package com.groupe2cs.bizyhub.security.domain.event;

	import com.groupe2cs.bizyhub.security.domain.valueObject.*;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCodeCreatedEvent implements Serializable {

	private VerificationCodeId id;
	private VerificationCodeToken token;
	private VerificationCodeUsername username;
	private VerificationCodeEmail email;
	private VerificationCodeCode code;
	private VerificationCodeStatus status;
	private VerificationCodeSource source;
	private VerificationCodeExpiration expiration;
	private VerificationCodeCreatedBy createdBy;
	private VerificationCodeTenant tenant;



}
