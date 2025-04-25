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
public class ApiKeyCreatedEvent implements Serializable {

	private ApiKeyId id;
	private ApiKeyAppKey appKey;
	private ApiKeyUsername username;
	private ApiKeyCreatedAt createdAt;
	private ApiKeyExpiration expiration;
	private ApiKeyCreatedBy createdBy;
	private ApiKeyTenant tenant;


}
