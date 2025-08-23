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

		@Schema(description = "", example = "828c3e77-b65f-4195-82d7-34e928eec553")
		private String remoteId;
		@Schema(description = "", example = "d3a25213-f700-430e-8f73-1420aef69e83")
		private String code;
		@Schema(description = "", example = "82c66d5e-e6d1-45fc-b6c6-ac409da7a351")
		private String notes;
		@Schema(description = "", example = "8683.35")
		private Double balance;
		@Schema(description = "", example = "6597.87")
		private Double balanceDebt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dueDate;
		@Schema(description = "", example = "6fe2cb1d-9b86-4164-a19c-ef4934950436")
		private String statuses;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "c180a98f-7c22-4471-bd9b-fe14a1559a40")
		private String customer;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
