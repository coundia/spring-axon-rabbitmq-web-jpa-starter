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

	@Schema(description = "", example = "89f9cf5b-dd86-446f-957c-a7d2947521af")
	private String notes;
	@Schema(description = "", example = "e71230a1-9d8c-4742-b5b4-a21b3c8c4d5d")
	private String token;
	@Schema(description = "", example = "c10eda23-a28f-4706-8f09-30854f90985a")
	private String username;
	@Schema(description = "", example = "a7fe56ba-1275-4a19-8883-97cc201c7397")
	private String phone;
	@Schema(description = "", example = "0d97bbba-9cc1-47db-8d8e-92786a148f81")
	private String email;
	@Schema(description = "", example = "9180b8e6-8adb-44bd-8391-6d88fedff262")
	private String code;
	@Schema(description = "", example = "535b9976-fbd2-43f1-b87c-a557509a4842")
	private String status;
	@Schema(description = "", example = "dd982ae1-95b5-4769-a659-8f4efeb39993")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
