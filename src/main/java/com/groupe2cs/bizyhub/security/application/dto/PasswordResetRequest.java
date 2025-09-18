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

	@Schema(description = "", example = "705c4133-ca4c-47aa-b5e7-a44c08a914d4")
	private String token;
	@Schema(description = "", example = "56603b0b-78f7-479c-9bd3-dabce5c816ce")
	private String username;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
