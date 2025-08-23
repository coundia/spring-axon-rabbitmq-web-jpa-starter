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

	@Schema(description = "", example = "a655b912-4c14-40bb-a0b5-1cf4204a1e80")
	private String appKey;
	@Schema(description = "", example = "3854d8e3-ca29-4a04-a3fc-342e64fde53b")
	private String username;
	@Schema(description = "", example = "true")
	private Boolean active;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
