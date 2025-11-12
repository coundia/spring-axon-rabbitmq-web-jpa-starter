package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ApiKeyRequest", description = "Request payload for ApiKey operations")
public class ApiKeyRequest implements Serializable {

	@Schema(description = "", example = "9ea652ff-cfe8-4765-93e6-13eac4e8ea65")
	private String appKey;
	@Schema(description = "", example = "7a1083fe-c60f-49b9-ad4e-8e2e22937d1c")
	private String username;
	@Schema(description = "", example = "false")
	private Boolean active;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
