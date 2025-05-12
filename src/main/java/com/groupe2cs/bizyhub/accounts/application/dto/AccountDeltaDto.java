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

		@Schema(description = "", example = "229dcb47-ebc2-4e8b-962a-4fee2c426b61")
		private String name;
		@Schema(description = "", example = "1234730c-469a-4ab8-b4e1-9fc26bb3a21a")
		private String currency;
		@Schema(description = "", example = "5746.37")
		private Double currentBalance;
		@Schema(description = "", example = "7249.71")
		private Double previousBalance;
		@Schema(description = "", example = "167d2e70-767f-4529-a263-187a5870d46d")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "abdf63a3-cba8-4006-af8d-b605fbf1afe9")
		private String reference;

}
