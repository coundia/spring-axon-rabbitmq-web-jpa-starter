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

	@Schema(description = "", example = "bd32a8cc-6a8e-45b0-8bbf-d6438b7aa93d")
	private String token;

	@Schema(description = "", example = "224ce9c9-801b-4555-b434-9b1dacdaaef8")
	private String username;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;


}
