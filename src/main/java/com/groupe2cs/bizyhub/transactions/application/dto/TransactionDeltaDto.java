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

		@Schema(description = "", example = "9097aacb-2246-47bc-afc3-eb8374990f00")
		private String name;
		@Schema(description = "", example = "4597.56")
		private Double amount;
		@Schema(description = "", example = "5e22c2d4-ba99-49a5-80fb-aee97dd56d9f")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "2ee9d657-9348-4ca4-b6be-efbbc8ecf83c")
		private String account;
		@Schema(description = "", example = "457ada5c-00c7-4125-a851-a6969a276855")
		private String category;
		@Schema(description = "", example = "3076e77d-2954-46cc-90e0-fe1a7bdfc023")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "9cd2ab97-d331-48c8-93bd-64c319e1f09d")
		private String reference;

}
