package com.groupe2cs.bizyhub.transactions.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "TransactionDeltaDto", description = "Delta DTO for transaction changes")
public class TransactionDeltaDto implements Serializable {

    @Schema(description = "Identifier of the transaction", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "558d6fd0-f487-4af6-b43e-d8861c50507c")
		private String name;
		@Schema(description = "", example = "4032.88")
		private Double amount;
		@Schema(description = "", example = "3498853c-8537-4190-a850-acc803a7788c")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "90e6e8b1-2936-46b0-8d98-bb0e9f195782")
		private String account;
		@Schema(description = "", example = "381a0c1d-3a5f-4742-a08c-6fe96cbd15d9")
		private String category;
		@Schema(description = "", example = "1acaf3e6-0174-4ab9-bc28-cad3953dff92")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "e400cf52-8106-4bb7-8931-7345f4ff85a6")
		private String reference;

}
