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

		@Schema(description = "", example = "56ac1023-9ca5-4224-bbce-8bf7a7e583be")
		private String name;
		@Schema(description = "", example = "9271.62")
		private Double amount;
		@Schema(description = "", example = "2201afc9-69a4-4952-bf26-84724b8a1115")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "8cdb26b6-7c91-4489-8879-abda1992e3f3")
		private String account;
		@Schema(description = "", example = "9ae2d49d-910e-4aa6-b451-86cd74442571")
		private String category;
		@Schema(description = "", example = "0a70b89f-92a5-4bc6-9534-1a3b1169eb54")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "989f60fd-f5e8-4051-a04a-1658542e6c56")
		private String reference;

}
