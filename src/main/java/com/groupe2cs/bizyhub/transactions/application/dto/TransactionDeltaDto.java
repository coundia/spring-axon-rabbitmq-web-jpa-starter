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

		@Schema(description = "", example = "2774f718-6800-43bb-aebc-caee6fd8652f")
		private String name;
		@Schema(description = "", example = "1879.13")
		private Double amount;
		@Schema(description = "", example = "820721f8-9253-4930-a633-e51b440d6049")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "549b254e-d109-476c-8766-d387f5b3298b")
		private String account;
		@Schema(description = "", example = "fbdbb5fd-25e6-4564-b058-aef6b631f34f")
		private String category;
		@Schema(description = "", example = "24578728-ca2a-42d7-9150-20e3105ac3d3")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "e2f00613-3a05-4394-8342-1876daf578d1")
		private String reference;

}
