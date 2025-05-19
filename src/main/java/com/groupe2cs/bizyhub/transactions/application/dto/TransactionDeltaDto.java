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

		@Schema(description = "", example = "a86349bc-d1df-4173-8bf0-afd6733eb9b1")
		private String name;
		@Schema(description = "", example = "7335.23")
		private Double amount;
		@Schema(description = "", example = "f8de9f45-af42-4295-ba8b-c69b32fc37c2")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "fd8d4d12-cdb0-4651-91ca-2cd9da94c6e5")
		private String account;
		@Schema(description = "", example = "19cca2ac-3a1f-48d5-bdfe-84f33c10d5f1")
		private String category;
		@Schema(description = "", example = "d46b58f7-e3a2-4e00-a833-4c255925a65a")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "57f5bcbc-3324-4a3f-98ed-239a93be3b25")
		private String reference;

}
