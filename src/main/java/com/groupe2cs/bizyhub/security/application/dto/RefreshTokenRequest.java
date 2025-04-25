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

	@Schema(description = "", example = "57a8ef6f-aa09-4f9c-8475-a3cb1397abd8")
	private String token;

	@Schema(description = "", example = "39e8e367-3f99-4635-9d3a-29e55289a6e4")
	private String username;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;


}
