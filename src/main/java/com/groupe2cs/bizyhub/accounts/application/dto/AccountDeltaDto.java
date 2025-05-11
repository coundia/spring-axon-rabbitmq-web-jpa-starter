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
@Schema(name = "AccountDeltaDto", description = "Delta DTO for account changes")
public class AccountDeltaDto implements Serializable {

    @Schema(description = "Identifier of the account", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "64db1cc1-56e7-4f58-95e1-14f6ea3e1c9e")
		private String name;
		@Schema(description = "", example = "35df3df4-0fc8-47de-a5db-92f69f3292fd")
		private String currency;
		@Schema(description = "", example = "1022.88")
		private Double currentBalance;
		@Schema(description = "", example = "9703.27")
		private Double previousBalance;
		@Schema(description = "", example = "112a2d5d-77ec-4c50-85e0-96cb0b0b0c1b")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "e3a6cb6d-a3e7-4783-b1d4-c50efbbf9eb6")
		private String reference;

}
