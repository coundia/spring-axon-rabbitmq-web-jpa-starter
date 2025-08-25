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

		@Schema(description = "", example = "3b84e113-17c9-4a8b-a7ce-6ac5a217cfd3")
		private String remoteId;
		@Schema(description = "", example = "173d2014-7392-4b3b-8706-c55374540fa3")
		private String localId;
		@Schema(description = "", example = "091cbde5-c110-49c5-a6a9-66c719ff219b")
		private String code;
		@Schema(description = "", example = "7688d0cd-2972-4b0d-ab28-c9a0337f8e93")
		private String notes;
		@Schema(description = "", example = "2098.39")
		private Double balance;
		@Schema(description = "", example = "6157.21")
		private Double balanceDebt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dueDate;
		@Schema(description = "", example = "bfe7e4fb-b3ec-4be2-85ce-0c19704c1e0d")
		private String statuses;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "94878412-f5be-4b9e-b943-976de8954dac")
		private String customer;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
