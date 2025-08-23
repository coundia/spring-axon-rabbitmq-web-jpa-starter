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

	@Schema(description = "", example = "f97666a6-c362-4bdf-a7a5-6f7f951b8291")
	private String notes;
	@Schema(description = "", example = "12c1acb1-8939-44f7-bafa-032d5ef3cef7")
	private String token;
	@Schema(description = "", example = "c7b6a014-587f-4248-93a7-bc4000ccf9d5")
	private String username;
	@Schema(description = "", example = "0e5a4d65-7cd2-47fb-82b1-37858b95d421")
	private String phone;
	@Schema(description = "", example = "44021938-aeb4-43e8-a360-9bbbe3d6afc6")
	private String email;
	@Schema(description = "", example = "0cc92a67-99f8-43e6-868e-d2cd1b0e706b")
	private String code;
	@Schema(description = "", example = "77ecba2a-3ac3-4f1d-b635-a36d037a6ef6")
	private String status;
	@Schema(description = "", example = "46b26f2d-75bc-4fef-9ef5-2a77be9e1f22")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
