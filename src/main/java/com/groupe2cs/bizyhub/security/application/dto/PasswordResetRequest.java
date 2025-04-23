package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "PasswordResetRequest", description = "Request payload for PasswordReset operations")
public class PasswordResetRequest implements Serializable {

	@Schema(description = "", example = "1f3a04a7-a41c-4498-aea4-73805b1fbdcb")
	private String token;

	@Schema(description = "", example = "6f4dc22b-4a57-4fcf-b37a-7d75bf21bbd9")
	private String username;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;


}
