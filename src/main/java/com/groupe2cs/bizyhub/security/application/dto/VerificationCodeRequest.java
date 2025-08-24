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

	@Schema(description = "", example = "6a0c85d4-6e7e-4476-9df3-ef4fdff2edf8")
	private String notes;
	@Schema(description = "", example = "8255a4f3-c767-4115-897e-f834f01c2a53")
	private String token;
	@Schema(description = "", example = "934f5e37-a408-4fb4-97fc-6e50ffd49643")
	private String username;
	@Schema(description = "", example = "f10475bf-e110-425f-934b-2e37b5fa823e")
	private String phone;
	@Schema(description = "", example = "4a0c4993-fc55-467a-b3a5-925f125c4fc8")
	private String email;
	@Schema(description = "", example = "89f25069-90f0-4ebd-b2e4-6554262be983")
	private String code;
	@Schema(description = "", example = "1023793f-20d2-49aa-9a61-ff27096e5528")
	private String status;
	@Schema(description = "", example = "e093d6ac-ac54-456f-b82e-b60aefd5f66e")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
