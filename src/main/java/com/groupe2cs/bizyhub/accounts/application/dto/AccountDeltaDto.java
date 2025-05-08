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

		@Schema(description = "", example = "cb3f4e31-372a-4e75-b33c-4d59279405b8")
		private String name;
		@Schema(description = "", example = "9ce582f0-b0ee-4aa5-8fdf-d9b38d59b11f")
		private String currency;
		@Schema(description = "", example = "53.35")
		private Double currentBalance;
		@Schema(description = "", example = "8260.66")
		private Double previousBalance;
		@Schema(description = "", example = "18d9f532-516d-4fc5-b87a-9353095ef3c1")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "ffe480b5-bea7-4a77-9037-7fdd7e1859dd")
		private String reference;

}
