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

		@Schema(description = "", example = "67cccd0c-0d59-4640-9b36-4972c9100fda")
		private String name;
		@Schema(description = "", example = "7746.43")
		private Double amount;
		@Schema(description = "", example = "faf4e0b3-5075-4037-9de7-8dfdf0c04a4d")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "e6eb8d75-b118-4687-9929-c3fbb827c371")
		private String account;
		@Schema(description = "", example = "24a893a8-73ed-443f-8f1e-100eec30a51e")
		private String category;
		@Schema(description = "", example = "a325fe63-38e4-4344-ba82-637f41c453f1")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "a16b2442-5605-44bc-9ebb-7c31e9368269")
		private String reference;

}
