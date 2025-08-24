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

		@Schema(description = "", example = "f4033856-d868-45e1-a05e-565b5e5c2f99")
		private String code;
		@Schema(description = "", example = "b2f25a08-68fc-4fc2-8f62-187b7b60c18f")
		private String name;
		@Schema(description = "", example = "b6ef5d5f-7c28-4b21-8c23-f308b9573b43")
		private String status;
		@Schema(description = "", example = "c9e8d0fc-f633-4b45-b1e0-89d1124d9889")
		private String currency;
		@Schema(description = "", example = "4c40b49f-2334-494f-87e8-9bd0a5076884")
		private String typeAccount;
		@Schema(description = "", example = "89.86")
		private Double balance;
		@Schema(description = "", example = "9518.08")
		private Double balancePrev;
		@Schema(description = "", example = "5761.53")
		private Double balanceBlocked;
		@Schema(description = "", example = "8277.93")
		private Double balanceInit;
		@Schema(description = "", example = "1683.31")
		private Double balanceGoal;
		@Schema(description = "", example = "7159.38")
		private Double balanceLimit;
		@Schema(description = "", example = "94a5a6fd-83c5-4a60-bd00-fa84e79a34c8")
		private String description;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "true")
		private Boolean isDefault;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
