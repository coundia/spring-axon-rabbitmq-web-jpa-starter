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

		@Schema(description = "", example = "04f5c63d-e047-4755-a981-35edcebad371")
		private String name;
		@Schema(description = "", example = "58bf5704-e854-457d-9d39-44b0de8d1494")
		private String account;
		@Schema(description = "", example = "e3b44a6c-523d-4be5-a9c6-e617cefbf466")
		private String user;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "a823d780-1ad2-4b5e-9ebf-178e478c428c")
		private String username;
		@Schema(description = "", example = "42e162e5-a428-49a1-aa57-6024f76f4a04")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
