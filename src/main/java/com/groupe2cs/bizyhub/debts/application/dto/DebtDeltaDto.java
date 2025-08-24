package com.groupe2cs.bizyhub.debts.application.dto;

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
@Schema(name = "DebtDeltaDto", description = "Delta DTO for debt changes")
public class DebtDeltaDto implements Serializable {

    @Schema(description = "Identifier of the debt", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "b2786727-f4bf-4e69-bf13-2219037ae90e")
		private String remoteId;
		@Schema(description = "", example = "e6ecc696-6c1d-490d-9d42-b92717b83064")
		private String code;
		@Schema(description = "", example = "fb0d4f3d-b473-4385-8e5c-c3b6c2e6865c")
		private String notes;
		@Schema(description = "", example = "2150.72")
		private Double balance;
		@Schema(description = "", example = "8539.42")
		private Double balanceDebt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dueDate;
		@Schema(description = "", example = "2464e86f-f7c0-4d4c-8961-bb365fc2ecd7")
		private String statuses;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "b13cff62-f2ca-4993-8b1f-f40b2357c620")
		private String customer;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
