package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "ApiKeyResponse", description = "Response payload for ApiKey")
public class ApiKeyResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String appKey;
	@Schema(description = "", example = "")
	private String username;
	@Schema(description = "", example = "")
	private java.time.Instant createdAt;
	@Schema(description = "", example = "")
	private java.time.Instant expiration;

}
