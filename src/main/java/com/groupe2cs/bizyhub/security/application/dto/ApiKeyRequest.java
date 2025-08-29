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

	@Schema(description = "", example = "7ef9979c-5b55-493e-bde2-f0de5f14c199")
	private String appKey;
	@Schema(description = "", example = "eec495e3-1fa6-442e-bf15-5556b3d3f3eb")
	private String username;
	@Schema(description = "", example = "true")
	private Boolean active;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
