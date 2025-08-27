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

	@Schema(description = "", example = "41a858a3-ca2b-4b2a-9205-ea9fc27d8445")
	private String notes;
	@Schema(description = "", example = "ace3ccd9-300f-40b0-a04c-38afa02483c7")
	private String token;
	@Schema(description = "", example = "8000ce1e-83bb-459d-9700-817094e17538")
	private String username;
	@Schema(description = "", example = "94b5b3cd-2ce0-4ba1-a709-e3c3640829f4")
	private String phone;
	@Schema(description = "", example = "7c7bed87-3cbc-4006-a888-a4e0113fe9f4")
	private String email;
	@Schema(description = "", example = "ecfb78d2-d970-42e5-abee-281943b9b056")
	private String code;
	@Schema(description = "", example = "ad41ba28-d068-4f1c-a1aa-4c5e8557b59c")
	private String status;
	@Schema(description = "", example = "85d732b5-c5c7-4e44-bfb7-3755032a1e43")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
