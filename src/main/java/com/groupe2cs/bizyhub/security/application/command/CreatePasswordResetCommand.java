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
public class CreatePasswordResetCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private PasswordResetId id = PasswordResetId.create(UUID.randomUUID().toString());
	private PasswordResetToken token;
	private PasswordResetUsername username;
	private PasswordResetExpiration expiration;
	private PasswordResetCreatedBy createdBy;
	private PasswordResetTenant tenant;

	public CreatePasswordResetCommand(

			PasswordResetToken token,
			PasswordResetUsername username,
			PasswordResetExpiration expiration,
			PasswordResetCreatedBy createdBy,
			PasswordResetTenant tenant
	) {
		this.id = PasswordResetId.create(UUID.randomUUID().toString());

		this.token = token;
		this.username = username;
		this.expiration = expiration;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
