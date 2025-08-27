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

	@Schema(description = "", example = "1676ec78-1767-495c-b6c0-e9dd296e1564")
	private String notes;
	@Schema(description = "", example = "72985605-95fa-4790-8bfc-e7ee3fc80fe9")
	private String token;
	@Schema(description = "", example = "58b4cc92-4cdd-4e6d-b971-e44682e525d9")
	private String username;
	@Schema(description = "", example = "d3d16c8e-1e99-4673-b72f-8cb16cc6ee82")
	private String phone;
	@Schema(description = "", example = "66e9c5da-e25a-4999-959b-67213e3450d1")
	private String email;
	@Schema(description = "", example = "1932d368-4013-4ed3-bf24-db8e414a2ec3")
	private String code;
	@Schema(description = "", example = "a742b026-29b4-4576-837f-0b1f4ecd6953")
	private String status;
	@Schema(description = "", example = "53524b25-7b20-42d2-a9ec-042e28d89877")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
