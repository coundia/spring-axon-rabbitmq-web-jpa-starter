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

	@Schema(description = "", example = "cae4b6d2-1b9a-45a9-a237-26427855bdfc")
	private String token;
	@Schema(description = "", example = "be0b29bc-47ac-4476-bd87-1a84a5c2c354")
	private String username;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
