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

		@Schema(description = "", example = "908518e3-c3fb-400b-b414-57781957f25c")
		private String code;
		@Schema(description = "", example = "363e0e65-02f8-4c00-b0b6-4b2058671fd1")
		private String name;
		@Schema(description = "", example = "09684a61-94f9-4c42-9c0b-4b6f7c6a0b84")
		private String status;
		@Schema(description = "", example = "fde6c5e2-08b4-4873-bebb-e3c50ccfd51f")
		private String currency;
		@Schema(description = "", example = "e1cc1677-6851-4115-a2a8-6a10d93b2767")
		private String typeAccount;
		@Schema(description = "", example = "4963.43")
		private Double balance;
		@Schema(description = "", example = "1105.28")
		private Double balancePrev;
		@Schema(description = "", example = "5611.94")
		private Double balanceBlocked;
		@Schema(description = "", example = "679.7")
		private Double balanceInit;
		@Schema(description = "", example = "4434.34")
		private Double balanceGoal;
		@Schema(description = "", example = "6873.66")
		private Double balanceLimit;
		@Schema(description = "", example = "7a5cf610-da3b-43a5-bd2f-cda36d41ae02")
		private String description;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "false")
		private Boolean isDefault;
		@Schema(description = "", example = "6fbd6803-4317-4169-9e95-7da892061dbb")
		private String remoteId;
		@Schema(description = "", example = "370ffa35-b33c-48fe-8e97-b7c7f66b055c")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
