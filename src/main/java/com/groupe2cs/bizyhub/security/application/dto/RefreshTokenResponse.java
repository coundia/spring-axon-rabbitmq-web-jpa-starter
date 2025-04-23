package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "RefreshTokenResponse", description = "Response payload for RefreshToken")
public class RefreshTokenResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String token;
	@Schema(description = "", example = "")
	private String username;
	@Schema(description = "", example = "")
	private java.time.Instant expiration;

}
