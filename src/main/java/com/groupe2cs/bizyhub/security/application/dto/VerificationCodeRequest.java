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

	@Schema(description = "", example = "2fa2b013-d921-4a10-a62b-0d56cbf24abe")
	private String notes;
	@Schema(description = "", example = "f7b7b0cf-1813-4c05-bc3c-fd2cf4fc8cf1")
	private String token;
	@Schema(description = "", example = "8db16aec-77f8-492b-9433-bd2ce84b1cd5")
	private String username;
	@Schema(description = "", example = "b6304a8f-bba8-47e5-9f4b-8eab39d3a106")
	private String phone;
	@Schema(description = "", example = "234af217-7e31-42d4-aeea-1bf579826e6d")
	private String email;
	@Schema(description = "", example = "031168dd-a1de-4665-a4df-634164d5b3c9")
	private String code;
	@Schema(description = "", example = "77767d77-b55c-407c-a511-c0fb845e2d9f")
	private String status;
	@Schema(description = "", example = "f2c97b95-5426-4332-b389-32d3430d96b6")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
