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

		@Schema(description = "", example = "439e1023-967b-4823-b04f-f974618cdab8")
		private String name;
		@Schema(description = "", example = "3dcb8c64-c246-4dd4-8adf-3bc0d8c994ab")
		private String currency;
		@Schema(description = "", example = "1211.62")
		private Double currentBalance;
		@Schema(description = "", example = "4403.59")
		private Double previousBalance;
		@Schema(description = "", example = "22cf94c2-de87-4ee0-8533-e48e16e35b96")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "3a5d70c9-ffdd-4973-8d68-a16c99b92160")
		private String reference;

}
