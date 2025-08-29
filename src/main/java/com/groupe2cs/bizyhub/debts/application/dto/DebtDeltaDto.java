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

		@Schema(description = "", example = "3c996167-5d08-49fa-843c-623007a8c57a")
		private String remoteId;
		@Schema(description = "", example = "310c6b65-cd2f-44d3-9268-ea70fd2ab3a7")
		private String localId;
		@Schema(description = "", example = "606cb5bb-1d6f-4145-937a-296bd950f0e8")
		private String code;
		@Schema(description = "", example = "f14d10e3-e91b-444e-914a-de2dc5700036")
		private String notes;
		@Schema(description = "", example = "5265.49")
		private Double balance;
		@Schema(description = "", example = "2814.56")
		private Double balanceDebt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dueDate;
		@Schema(description = "", example = "95fab688-a68f-425b-8c1b-10ba456ac27a")
		private String statuses;
		@Schema(description = "", example = "f59ee317-c3cd-4abb-ac45-1f791dfd767c")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "367766c4-c172-483a-8dff-7cb3855fbed0")
		private String customer;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
