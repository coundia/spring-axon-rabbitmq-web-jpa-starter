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

		@Schema(description = "", example = "1164.65")
		private Double amount;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateOperation;
		@Schema(description = "", example = "3b44cfa4-7f64-4429-a013-d5025b94206f")
		private String description;
		@Schema(description = "", example = "2a1b48cb-b6a6-46a8-bc6e-3cdcef612067")
		private String reference;
		@Schema(description = "", example = "false")
		private Boolean isRecurring;
		@Schema(description = "", example = "false")
		private Boolean isExcluToRapport;
		@Schema(description = "", example = "19190fe0-f462-448e-9536-7beb3cad8fde")
		private String status;
		@Schema(description = "", example = "251da151-5774-40f5-9cb3-a1701e262a7e")
		private String balance;
		@Schema(description = "", example = "37a9cf90-4206-4910-9e2d-03ded77c4f25")
		private String category;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant createdAt;

}
