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

	@Schema(description = "", example = "796c4b65-4d8a-4137-a82e-73435e9cd7fb")
	private String token;
	@Schema(description = "", example = "a14415cb-bb1d-403b-9ee3-fad33517fd8a")
	private String username;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
