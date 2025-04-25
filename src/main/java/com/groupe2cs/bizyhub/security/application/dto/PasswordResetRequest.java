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
@Schema(name = "PasswordResetRequest", description = "Request payload for PasswordReset operations")
public class PasswordResetRequest implements Serializable {

	@Schema(description = "", example = "09d8b3df-136c-44d2-a73f-7e1a774ce7d3")
	private String token;

	@Schema(description = "", example = "ab04cde1-5496-4eb9-8204-725ddbb22d5a")
	private String username;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;


}
