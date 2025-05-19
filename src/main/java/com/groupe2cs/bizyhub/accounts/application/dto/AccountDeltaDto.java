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

		@Schema(description = "", example = "fc4eb99c-0dfb-494e-a009-52d71f156f03")
		private String name;
		@Schema(description = "", example = "f17825bb-e21f-4068-8387-5e19c1b38347")
		private String currency;
		@Schema(description = "", example = "798.9")
		private Double currentBalance;
		@Schema(description = "", example = "1524.78")
		private Double previousBalance;
		@Schema(description = "", example = "af05c977-f55b-4843-bf6f-97fcd25b2056")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "e12744bc-26b5-4781-bb9c-8e1572a4e7ed")
		private String reference;

}
