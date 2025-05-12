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

		@Schema(description = "", example = "eb7e2fbe-cde4-4c6a-839e-236cfda4f52d")
		private String name;
		@Schema(description = "", example = "1459.19")
		private Double amount;
		@Schema(description = "", example = "94f5f962-29bc-4054-9e22-6646a010e129")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "4f672c01-b561-47df-8d76-2f07225f2f44")
		private String account;
		@Schema(description = "", example = "4f9eeec5-ab86-4206-be8b-dfda533dc7b4")
		private String category;
		@Schema(description = "", example = "a7b4bab2-af13-4d88-b487-88a1030788ea")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "27f238d9-1ab9-4f38-a120-bf7da63303e3")
		private String reference;

}
