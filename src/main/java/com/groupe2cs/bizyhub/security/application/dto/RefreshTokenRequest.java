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
@Schema(name = "RefreshTokenRequest", description = "Request payload for RefreshToken operations")
public class RefreshTokenRequest implements Serializable {

	@Schema(description = "", example = "68b30ff6-f826-4ebe-8037-841875ca816f")
	private String token;

	@Schema(description = "", example = "c9e647f3-aeeb-4193-aade-b60e9a7c265d")
	private String username;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;


}
