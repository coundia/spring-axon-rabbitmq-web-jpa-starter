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

		@Schema(description = "", example = "d8facfe9-f31b-4791-a6f4-6e6a7addd122")
		private String name;
		@Schema(description = "", example = "f505b782-7ca7-417c-85c6-18f349bb5bd5")
		private String account;
		@Schema(description = "", example = "3cd0125d-dc7b-4266-b4d7-d93f69bc4219")
		private String user;
		@Schema(description = "", example = "e4a8a5ad-4a53-41bb-8770-3f146171cd36")
		private String username;
		@Schema(description = "", example = "a5d8649d-8932-4ea5-9611-5b28229a3953")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
