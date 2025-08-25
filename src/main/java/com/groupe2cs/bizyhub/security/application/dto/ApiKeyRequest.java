package com.groupe2cs.bizyhub.security.application.dto;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import java.util.UUID;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ApiKeyRequest", description = "Request payload for ApiKey operations")
public class ApiKeyRequest implements Serializable {

	@Schema(description = "", example = "cdb604e6-c182-414f-ae9a-056c04ac54fd")
	private String appKey;
	@Schema(description = "", example = "a058dbc8-949b-46cd-9339-977afb96bfc1")
	private String username;
	@Schema(description = "", example = "true")
	private Boolean active;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
