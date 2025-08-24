package com.groupe2cs.bizyhub.transactions.application.dto;

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
@Schema(name = "TransactionDeltaDto", description = "Delta DTO for transaction changes")
public class TransactionDeltaDto implements Serializable {

    @Schema(description = "Identifier of the transaction", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "17b39e37-9e3c-4d6e-a175-7a08a5b71216")
		private String name;
		@Schema(description = "", example = "1548.2")
		private Double amount;
		@Schema(description = "", example = "d28c035a-3f03-4f35-aa42-cbc36bb8cf82")
		private String remoteId;
		@Schema(description = "", example = "3d0ab484-e63c-47c5-b694-17bf8300efd9")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "e61756ba-3493-4be8-b6dd-0060ca7e7ccf")
		private String account;
		@Schema(description = "", example = "cb5fa945-c802-4b75-87e8-046eead062d1")
		private String category;
		@Schema(description = "", example = "e49f4e38-60e4-47d2-a86d-d5b622e218c9")
		private String typeEntry;
		@Schema(description = "", example = "403e4758-df7a-451e-a8c2-44d377769774")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
