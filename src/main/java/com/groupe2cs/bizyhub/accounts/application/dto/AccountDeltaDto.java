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

		@Schema(description = "", example = "0e9fc24c-4760-4e25-af06-081ebf554a93")
		private String code;
		@Schema(description = "", example = "4a57d7bb-f868-410f-988b-1f9c2478c0ed")
		private String name;
		@Schema(description = "", example = "816cdfdb-1fca-4630-b41c-6c0b0173e38f")
		private String status;
		@Schema(description = "", example = "1a746c2d-96e4-426f-be00-6965866e070e")
		private String currency;
		@Schema(description = "", example = "c625ad75-e2ed-4c0f-8036-b6651d04804a")
		private String typeAccount;
		@Schema(description = "", example = "2941.58")
		private Double balance;
		@Schema(description = "", example = "6152.26")
		private Double balancePrev;
		@Schema(description = "", example = "2657.26")
		private Double balanceBlocked;
		@Schema(description = "", example = "8244.43")
		private Double balanceInit;
		@Schema(description = "", example = "7927.14")
		private Double balanceGoal;
		@Schema(description = "", example = "3151.7")
		private Double balanceLimit;
		@Schema(description = "", example = "51738911-d0bc-4b87-ad3f-8cd0dd99a0f5")
		private String description;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "false")
		private Boolean isDefault;
		@Schema(description = "", example = "669ed0ab-1967-4859-85f6-a46e62a6d4b2")
		private String remoteId;
		@Schema(description = "", example = "5400beeb-9ac8-491a-a943-714a8e68c16a")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
