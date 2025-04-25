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

	@Schema(description = "", example = "4c358630-778f-4f05-82f2-dad9f0445672")
	private String token;

	@Schema(description = "", example = "29e3c280-4129-4b0f-8a51-22a86b0d597d")
	private String username;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;


}
