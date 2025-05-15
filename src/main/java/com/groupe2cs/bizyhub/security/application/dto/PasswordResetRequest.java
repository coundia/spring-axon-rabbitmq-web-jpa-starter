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

	@Schema(description = "", example = "d692cf2c-4dff-426a-91cf-9ec0266d0ce7")
	private String token;

	@Schema(description = "", example = "7779d533-5eb4-43c4-a7af-745f3828676a")
	private String username;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;


}
