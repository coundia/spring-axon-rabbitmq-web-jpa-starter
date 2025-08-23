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

	@Schema(description = "", example = "f799068f-b26e-4f3c-a9d3-07f3887a59c2")
	private String notes;
	@Schema(description = "", example = "3aaf4438-81a4-4c20-851a-4b629ce9fdca")
	private String token;
	@Schema(description = "", example = "2efddc24-0d1d-44fc-84a7-2c852dd4a8b0")
	private String username;
	@Schema(description = "", example = "1c7cb98e-69c5-40f9-9bf7-16dc87bacf22")
	private String phone;
	@Schema(description = "", example = "6270079b-96c8-464c-a9c4-de08234811a7")
	private String email;
	@Schema(description = "", example = "fd5438e8-26bf-403e-8cb6-849bebc9c8e4")
	private String code;
	@Schema(description = "", example = "1fb92804-c2ef-43ee-bb68-e375251d7b30")
	private String status;
	@Schema(description = "", example = "552cfb1b-c81c-4352-90e2-38517b222db2")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
