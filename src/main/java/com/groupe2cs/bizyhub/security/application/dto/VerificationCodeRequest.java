package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "VerificationCodeRequest", description = "Request payload for VerificationCode operations")
public class VerificationCodeRequest implements Serializable {

	@Schema(description = "", example = "0038f7f4-56fe-410f-baf5-c32f1aceb4ef")
	private String notes;
	@Schema(description = "", example = "f5680c01-cad7-48c3-961c-d1c50a60ec50")
	private String token;
	@Schema(description = "", example = "c2b46601-0824-46a3-b918-7bf8d0faaa20")
	private String username;
	@Schema(description = "", example = "31606548-994e-4e20-bba0-15c50a984235")
	private String phone;
	@Schema(description = "", example = "0de08fd5-18bb-4793-ab8c-bc21f34705ac")
	private String email;
	@Schema(description = "", example = "144361a7-cf9a-4f0e-98f5-9af511adde12")
	private String code;
	@Schema(description = "", example = "79fc60ee-2e11-496b-a9e0-62c92e5f71c3")
	private String status;
	@Schema(description = "", example = "77c22a61-209f-4087-a675-1d968bf2e635")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
