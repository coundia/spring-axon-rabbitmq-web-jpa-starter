package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateVerificationCodeCommand implements Serializable {
	@TargetAggregateIdentifier
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
