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

		@Schema(description = "", example = "5454c60d-1b7e-45cd-8518-0027210fa3f6")
		private String code;
		@Schema(description = "", example = "191f1b1e-cb6c-4e13-8723-739e8623ccf1")
		private String name;
		@Schema(description = "", example = "0b328633-eeea-47b1-9954-a385bc876725")
		private String status;
		@Schema(description = "", example = "8df57db6-06fb-4524-91ea-7603c1105b90")
		private String currency;
		@Schema(description = "", example = "969c9732-83f5-4e9e-852b-8cba1595eaa1")
		private String typeAccount;
		@Schema(description = "", example = "8269.59")
		private Double balance;
		@Schema(description = "", example = "850.19")
		private Double balancePrev;
		@Schema(description = "", example = "3022.85")
		private Double balanceBlocked;
		@Schema(description = "", example = "6532.22")
		private Double balanceInit;
		@Schema(description = "", example = "3991.97")
		private Double balanceGoal;
		@Schema(description = "", example = "2341.5")
		private Double balanceLimit;
		@Schema(description = "", example = "6ffbeae4-08ee-48ec-ac73-45066433ce45")
		private String description;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "false")
		private Boolean isDefault;
		@Schema(description = "", example = "5f1bc9e4-4f4c-4fe4-a522-3f45c8fb11b0")
		private String remoteId;
		@Schema(description = "", example = "4757b486-4420-4720-b0d5-f864c8f9914d")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
