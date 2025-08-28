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

	@Schema(description = "", example = "69ab2e86-8f70-41aa-a57a-603474143d32")
	private String notes;
	@Schema(description = "", example = "51d1f9fe-d60d-49d9-bce7-07ae70f6f887")
	private String token;
	@Schema(description = "", example = "7c24cb52-60bf-44e1-8a39-87bcf6bed978")
	private String username;
	@Schema(description = "", example = "3fd9a7ca-bc0a-4f93-9a9d-6ef98b5a156c")
	private String phone;
	@Schema(description = "", example = "690637b0-04be-4e33-bf22-eee1696a3913")
	private String email;
	@Schema(description = "", example = "7a716fa0-9e6e-4896-8b68-bf0076bddd0f")
	private String code;
	@Schema(description = "", example = "75eccb25-ff83-4935-af26-b7c0ebd7e4b6")
	private String status;
	@Schema(description = "", example = "940602ba-6701-49f4-8934-63653de69ff1")
	private String source;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant expiration;

}
