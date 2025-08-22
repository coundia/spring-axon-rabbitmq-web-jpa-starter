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

	@Schema(description = "", example = "0d5f2f85-da95-4ee6-8be9-db61fe2f3341")
	private String appKey;
	@Schema(description = "", example = "71e51d36-9c73-4f89-a503-8a343197bb7d")
	private String username;
	@Schema(description = "", example = "false")
	private Boolean active;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
