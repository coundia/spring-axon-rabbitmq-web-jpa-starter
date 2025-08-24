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

		@Schema(description = "", example = "c9edb63c-a61e-4c56-bbce-975d31d1a3c5")
		private String code;
		@Schema(description = "", example = "153e0490-488b-42c1-ab70-2e5327744b70")
		private String name;
		@Schema(description = "", example = "a4923b0b-9e63-440e-868e-1f70b8caf823")
		private String status;
		@Schema(description = "", example = "ef916296-a84b-438d-8adc-f8bade9f6987")
		private String currency;
		@Schema(description = "", example = "d5bf4160-45b9-4627-95f3-21f513a779a2")
		private String typeAccount;
		@Schema(description = "", example = "3420.99")
		private Double balance;
		@Schema(description = "", example = "3213.82")
		private Double balancePrev;
		@Schema(description = "", example = "5369.65")
		private Double balanceBlocked;
		@Schema(description = "", example = "8722.7")
		private Double balanceInit;
		@Schema(description = "", example = "2285.58")
		private Double balanceGoal;
		@Schema(description = "", example = "7896.23")
		private Double balanceLimit;
		@Schema(description = "", example = "b646a764-90f6-4787-9dd4-55af4957dfd6")
		private String description;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "true")
		private Boolean isDefault;
		@Schema(description = "", example = "0ff64492-fe7d-4185-9830-47fbe2de9aab")
		private String remoteId;
		@Schema(description = "", example = "be5a83ff-230a-4713-9e5e-b3fd6f252764")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;

}
