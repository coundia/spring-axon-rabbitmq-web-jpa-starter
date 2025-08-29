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
public class CreateApiKeyCommand implements Serializable {
	@TargetAggregateIdentifier
	@Builder.Default
	private ApiKeyId id = ApiKeyId.create(UUID.randomUUID().toString());
	private ApiKeyAppKey appKey;
	private ApiKeyUsername username;
	private ApiKeyActive active;
	private ApiKeyCreatedAt createdAt;
	private ApiKeyExpiration expiration;
	private ApiKeyCreatedBy createdBy;
	private ApiKeyTenant tenant;

	public CreateApiKeyCommand(

			ApiKeyAppKey appKey,
			ApiKeyUsername username,
			ApiKeyActive active,
			ApiKeyCreatedAt createdAt,
			ApiKeyExpiration expiration,
			ApiKeyCreatedBy createdBy,
			ApiKeyTenant tenant
	) {
		this.id = ApiKeyId.create(UUID.randomUUID().toString());

		this.appKey = appKey;
		this.username = username;
		this.active = active;
		this.createdAt = createdAt;
		this.expiration = expiration;
		this.createdBy = createdBy;
		this.tenant = tenant;
	}


}
