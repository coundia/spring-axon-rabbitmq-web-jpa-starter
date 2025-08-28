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

		@Schema(description = "", example = "0ca8e32d-ce0d-4718-96df-1c129610595d")
		private String remoteId;
		@Schema(description = "", example = "97d27151-4f42-4d7f-9a4d-7f91aabccb8d")
		private String localId;
		@Schema(description = "", example = "16456c89-a4e1-4016-bab5-109bd767630c")
		private String code;
		@Schema(description = "", example = "048614aa-eb6c-458e-a4f8-87785b98f908")
		private String notes;
		@Schema(description = "", example = "5298.33")
		private Double balance;
		@Schema(description = "", example = "558.61")
		private Double balanceDebt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dueDate;
		@Schema(description = "", example = "e54e627e-e3aa-45e3-878b-f0b35d678397")
		private String statuses;
		@Schema(description = "", example = "0e367dfc-7a49-4601-86fb-343a754faf77")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "2970bd97-d177-494b-8ded-8345dd54646d")
		private String customer;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
