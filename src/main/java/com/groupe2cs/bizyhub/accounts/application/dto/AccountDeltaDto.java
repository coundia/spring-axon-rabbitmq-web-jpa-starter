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
@Schema(name = "AccountDeltaDto", description = "Delta DTO for account changes")
public class AccountDeltaDto implements Serializable {

    @Schema(description = "Identifier of the account", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "799026ec-f045-4325-a2c0-00a5a8bf7973")
		private String code;
		@Schema(description = "", example = "cb3cfd3f-6256-4ccd-ba8b-4503666adaa9")
		private String name;
		@Schema(description = "", example = "1e8c4539-af19-4be6-8f56-774e37d0ece6")
		private String status;
		@Schema(description = "", example = "ba4285c6-b5e8-4271-bb65-e9a1b3546748")
		private String currency;
		@Schema(description = "", example = "69ee9231-352c-4469-a052-09f3118dde6e")
		private String typeAccount;
		@Schema(description = "", example = "9892.04")
		private Double balance;
		@Schema(description = "", example = "921.87")
		private Double balancePrev;
		@Schema(description = "", example = "305.64")
		private Double balanceBlocked;
		@Schema(description = "", example = "8423.38")
		private Double balanceInit;
		@Schema(description = "", example = "2541.25")
		private Double balanceGoal;
		@Schema(description = "", example = "4736.09")
		private Double balanceLimit;
		@Schema(description = "", example = "d89dbf09-93b7-4d40-98b9-fde04fb808d9")
		private String description;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "false")
		private Boolean isDefault;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
