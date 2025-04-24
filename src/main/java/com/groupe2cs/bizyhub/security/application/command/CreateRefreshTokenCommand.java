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
public class CreateRefreshTokenCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private RefreshTokenId id = RefreshTokenId.create(UUID.randomUUID().toString());
	private RefreshTokenToken token;
	private RefreshTokenUsername username;
	private RefreshTokenExpiration expiration;
	private RefreshTokenCreatedBy createdBy;

	public CreateRefreshTokenCommand(

			RefreshTokenToken token,
			RefreshTokenUsername username,
			RefreshTokenExpiration expiration,
			RefreshTokenCreatedBy createdBy
	) {
		this.id = RefreshTokenId.create(UUID.randomUUID().toString());

		this.token = token;
		this.username = username;
		this.expiration = expiration;
		this.createdBy = createdBy;
	}


}
