package com.groupe2cs.bizyhub.accounts.application.dto;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
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
@Schema(name = "AccountUserRequest", description = "Request payload for AccountUser operations")
public class AccountUserRequest implements Serializable {

	@Schema(description = "", example = "fbb110df-24b1-4b4f-ad1c-a3a046baf1ba")
	private String name;
	@Schema(description = "", example = "847ae0e9-e5a2-4171-b714-34268e826eaf")
	private String account;
	@Schema(description = "", example = "fc16b2fa-9c80-4c84-902f-745e03ef20a0")
	private String user;
	@Schema(description = "", example = "a4bb1d58-2f57-49cd-9cc0-eeeaba5e8a46")
	private String username;
	@Schema(description = "", example = "887ed3a3-ff2a-4a7f-8f32-f6544b5eacf5")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
