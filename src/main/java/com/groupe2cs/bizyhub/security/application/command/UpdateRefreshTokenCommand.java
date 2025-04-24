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
public class UpdateRefreshTokenCommand implements Serializable {
	@TargetAggregateIdentifier
	private RefreshTokenId id;
	private RefreshTokenToken token;
	private RefreshTokenUsername username;
	private RefreshTokenExpiration expiration;
	private RefreshTokenCreatedBy createdBy;


}
