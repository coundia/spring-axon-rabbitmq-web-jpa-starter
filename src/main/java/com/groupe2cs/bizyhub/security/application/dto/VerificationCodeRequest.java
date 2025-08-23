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

	@Schema(description = "", example = "618d515c-c7ee-4d78-8028-00c1a4395487")
	private String notes;
	@Schema(description = "", example = "5af4d304-fe0f-42dc-a525-cfcce83025a2")
	private String token;
	@Schema(description = "", example = "4fbd34ac-f6eb-4e85-b7c6-ad04c7c0a1a6")
	private String username;
	@Schema(description = "", example = "8f652ed3-a9df-424b-bbb0-e9c06035cbed")
	private String phone;
	@Schema(description = "", example = "a1477555-5c2b-433c-80e3-e768101024c6")
	private String email;
	@Schema(description = "", example = "d04266fc-8987-467a-bb6b-0c209dbffafc")
	private String code;
	@Schema(description = "", example = "637092d6-a392-4dc0-9578-aca086a7a500")
	private String status;
	@Schema(description = "", example = "2a5fac66-8bf8-4543-9564-0f570d1cd17d")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
