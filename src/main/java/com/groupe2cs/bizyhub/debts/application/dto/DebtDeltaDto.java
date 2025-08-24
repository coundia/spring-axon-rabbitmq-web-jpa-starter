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

		@Schema(description = "", example = "4c1a4c35-8388-4ac1-871a-2afb649242dd")
		private String remoteId;
		@Schema(description = "", example = "751062ec-c62e-4ef1-b692-065fc571465c")
		private String localId;
		@Schema(description = "", example = "20f80a4e-f93f-45fb-ac65-8d8fede32391")
		private String code;
		@Schema(description = "", example = "c995028a-eeed-48da-8d87-bceaf0fcc8fd")
		private String notes;
		@Schema(description = "", example = "4763.12")
		private Double balance;
		@Schema(description = "", example = "5252.62")
		private Double balanceDebt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dueDate;
		@Schema(description = "", example = "c5f234ff-e7bd-4ede-83a6-b0452563dbbb")
		private String statuses;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "a38d6917-c1d5-4575-bddc-f5a1e9d6789b")
		private String customer;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
