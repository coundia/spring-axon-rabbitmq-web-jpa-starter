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

		@Schema(description = "", example = "39044bb3-c12c-4e82-afe7-ab2473191224")
		private String name;
		@Schema(description = "", example = "3e35e53e-8548-4ce7-8a08-f93d10ed0fd1")
		private String account;
		@Schema(description = "", example = "e7d04f47-1089-4220-b075-631f1a5be767")
		private String user;
		@Schema(description = "", example = "0c8645b8-e68e-4bb9-9417-61808a82464e")
		private String username;
		@Schema(description = "", example = "ca587fda-c1a8-4b7d-a44f-fbc19ed07ccc")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "b7b8a940-1275-4636-8387-390273d87f79")
		private String reference;

}
