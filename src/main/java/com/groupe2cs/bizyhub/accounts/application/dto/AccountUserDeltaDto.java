package com.groupe2cs.bizyhub.accounts.application.dto;

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
@Schema(name = "AccountUserDeltaDto", description = "Delta DTO for accountUser changes")
public class AccountUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the accountUser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "25e3b811-7aa5-4e10-880d-9cb4839a2632")
		private String name;
		@Schema(description = "", example = "ae3b53b4-ce82-4688-ae8b-8abd53a4f71f")
		private String account;
		@Schema(description = "", example = "ba7cdcb5-7b55-4fdf-9456-98d2678f21ac")
		private String user;
		@Schema(description = "", example = "62177732-416b-4bdd-ad90-d51e231c90de")
		private String username;
		@Schema(description = "", example = "ade7d003-4334-4089-a328-5c1d6c075911")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "91ed90ad-defc-4064-8907-9aa7b30c498f")
		private String reference;

}
