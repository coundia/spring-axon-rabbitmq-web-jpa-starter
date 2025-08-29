package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "VerificationCodeResponse", description = "Response payload for VerificationCode")
public class VerificationCodeResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String notes;
	@Schema(description = "", example = "")
	private String token;
	@Schema(description = "", example = "")
	private String username;
	@Schema(description = "", example = "")
	private String phone;
	@Schema(description = "", example = "")
	private String email;
	@Schema(description = "", example = "")
	private String code;
	@Schema(description = "", example = "")
	private String status;
	@Schema(description = "", example = "")
	private String source;
	@Schema(description = "", example = "")
	private java.time.Instant expiration;
	@Schema(description = "", example = "")
	private String createdBy;
	@Schema(description = "", example = "")
	private String tenant;

}
