package com.groupe2cs.bizyhub.accounts.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "AccountUserDeltaDto", description = "Delta DTO for accountUser changes")
public class AccountUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the accountUser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "5d8c2d5e-e4e8-413b-a673-275b3c5a36c9")
		private String name;
		@Schema(description = "", example = "db628e3f-7a1f-41e6-be35-d0d16654e07c")
		private String account;
		@Schema(description = "", example = "42608492-d96f-4a35-b511-0c19d08954c6")
		private String user;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "8c756e81-ce00-4f89-82d6-4a9511508a21")
		private String username;
		@Schema(description = "", example = "ab86215c-02e5-41b5-b955-16de44b538c6")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
