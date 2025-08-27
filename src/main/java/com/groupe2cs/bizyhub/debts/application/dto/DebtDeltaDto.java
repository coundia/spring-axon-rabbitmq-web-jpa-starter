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

		@Schema(description = "", example = "4f153b9c-b287-4788-a957-24be67aca56e")
		private String remoteId;
		@Schema(description = "", example = "d6b30f54-d9f4-4a35-a87e-1516d86cbc44")
		private String localId;
		@Schema(description = "", example = "b7152aca-03e6-4a4e-b0f3-f6cc7c1cec3d")
		private String code;
		@Schema(description = "", example = "c2705115-1e30-474c-8dea-dc6f74c0016d")
		private String notes;
		@Schema(description = "", example = "5203.79")
		private Double balance;
		@Schema(description = "", example = "4876.8")
		private Double balanceDebt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dueDate;
		@Schema(description = "", example = "76fbef98-9254-4c55-b1a5-17894bad0a14")
		private String statuses;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "30c7dbc1-6194-48c7-b79f-f10cd37c06bc")
		private String customer;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
