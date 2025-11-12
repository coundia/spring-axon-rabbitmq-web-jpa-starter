package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateVerificationCodeCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private VerificationCodeId id = VerificationCodeId.create(UUID.randomUUID().toString());
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

	public CreateVerificationCodeCommand(

			VerificationCodeNotes notes,
			VerificationCodeToken token,
			VerificationCodeUsername username,
			VerificationCodePhone phone,
			VerificationCodeEmail email,
			VerificationCodeCode code,
			VerificationCodeStatus status,
			VerificationCodeSource source,
			VerificationCodeExpiration expiration,
			VerificationCodeCreatedBy createdBy,
			VerificationCodeTenant tenant
	) {
		this.id = VerificationCodeId.create(UUID.randomUUID().toString());

		this.notes = notes;
		this.token = token;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.code = code;
		this.status = status;
		this.source = source;
		this.expiration = expiration;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
