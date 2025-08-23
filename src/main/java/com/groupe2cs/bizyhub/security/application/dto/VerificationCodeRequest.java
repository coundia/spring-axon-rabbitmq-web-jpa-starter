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

	@Schema(description = "", example = "23c54af2-121a-476f-9043-9943d009fcf5")
	private String token;
	@Schema(description = "", example = "2c410483-732a-4e81-adc9-b8f46cc1c5b4")
	private String username;
	@Schema(description = "", example = "83e6486a-2195-4c60-8080-6f46f25b2044")
	private String phone;
	@Schema(description = "", example = "1452f35c-3d96-454a-90c1-499619ed74b6")
	private String email;
	@Schema(description = "", example = "a913e2f6-e03e-404f-ad25-201dbc69983d")
	private String code;
	@Schema(description = "", example = "33c982bc-61c0-4237-946a-c486c6fa8285")
	private String status;
	@Schema(description = "", example = "4636fefb-831a-41ba-94f1-14aa60f389fa")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
