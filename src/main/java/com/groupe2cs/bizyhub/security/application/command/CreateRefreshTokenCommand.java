package com.groupe2cs.bizyhub.security.application.command;

import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenExpiration;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenId;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenToken;
import com.groupe2cs.bizyhub.security.domain.valueObject.RefreshTokenUsername;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRefreshTokenCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private RefreshTokenId id = RefreshTokenId.create(UUID.randomUUID().toString());
	private RefreshTokenToken token;
	private RefreshTokenUsername username;
	private RefreshTokenExpiration expiration;

	public CreateRefreshTokenCommand(

			RefreshTokenToken token,
			RefreshTokenUsername username,
			RefreshTokenExpiration expiration
	) {
		this.id = RefreshTokenId.create(UUID.randomUUID().toString());

		this.token = token;
		this.username = username;
		this.expiration = expiration;
	}


}
