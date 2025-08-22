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
@Schema(name = "VerificationCodeRequest", description = "Request payload for VerificationCode operations")
public class VerificationCodeRequest implements Serializable {

	@Schema(description = "", example = "0be89103-d056-426b-a694-4c22c2e8cb12")
	private String token;
	@Schema(description = "", example = "79b5b48a-28c3-4195-9f8a-f4ece8c96731")
	private String username;
	@Schema(description = "", example = "c9f9292d-d00c-4631-b3f4-8bedde1b6603")
	private String email;
	@Schema(description = "", example = "936ca716-ef1a-456e-bd7d-eee148cae046")
	private String code;
	@Schema(description = "", example = "0bb0e216-1d18-479b-adc3-b692870d6bff")
	private String status;
	@Schema(description = "", example = "937e12d0-cd3d-47af-9d62-2bce0912ead0")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
