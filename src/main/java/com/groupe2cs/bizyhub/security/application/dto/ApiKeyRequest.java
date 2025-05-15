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

	@Schema(description = "", example = "babae696-a79f-4bb0-a1d0-a7d76a3597f1")
	private String appKey;

	@Schema(description = "", example = "51d96218-2070-46fc-8773-4730ccf12d8c")
	private String username;

	@Schema(description = "", example = "false")
	private Boolean active;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant createdAt;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;


}
