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

	@Schema(description = "", example = "70ef1fc0-3229-4ff2-b8af-df76c3f91027")
	private String notes;
	@Schema(description = "", example = "62d894b7-bd15-43a3-95aa-27df098592d8")
	private String token;
	@Schema(description = "", example = "5290704e-e603-4c01-828f-385628a27e07")
	private String username;
	@Schema(description = "", example = "1cd7f350-a1ce-48f4-ba61-e683dc9c0915")
	private String phone;
	@Schema(description = "", example = "cd459829-5132-493b-883b-d8de14def98d")
	private String email;
	@Schema(description = "", example = "6401424e-5fb8-40c2-95e0-2322e0c69745")
	private String code;
	@Schema(description = "", example = "a8fbaf22-e13d-47c2-89e9-480d63902cd7")
	private String status;
	@Schema(description = "", example = "9279e855-9c67-49a1-a723-3826ef23be26")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
