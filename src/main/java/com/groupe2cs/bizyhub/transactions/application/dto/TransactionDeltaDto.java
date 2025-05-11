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

		@Schema(description = "", example = "c58d422d-e29b-4521-95ed-bd01bbc3bccd")
		private String name;
		@Schema(description = "", example = "4547.76")
		private Double amount;
		@Schema(description = "", example = "4a5a0752-75cc-4333-8498-90603bf91072")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "e3e6cb3f-b489-4d64-9106-b960819f945b")
		private String account;
		@Schema(description = "", example = "9eb9683d-1842-4390-a839-57e793023ecc")
		private String category;
		@Schema(description = "", example = "756b411d-b0d0-460d-9b9b-1c2880791d67")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "d5873b37-1c27-452c-81dd-cf77958a2621")
		private String reference;

}
