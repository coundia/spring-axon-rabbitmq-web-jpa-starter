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
public class UpdateApiKeyCommand implements Serializable {
	@TargetAggregateIdentifier
	private ApiKeyId id;
	private ApiKeyAppKey appKey;
	private ApiKeyUsername username;
	private ApiKeyActive active;
	private ApiKeyCreatedAt createdAt;
	private ApiKeyExpiration expiration;
	private ApiKeyCreatedBy createdBy;
	private ApiKeyTenant tenant;


}
