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

		@Schema(description = "", example = "e33786bb-ff30-4d3e-9d81-b96f9b4c3a5b")
		private String name;
		@Schema(description = "", example = "1305.21")
		private Double amount;
		@Schema(description = "", example = "96f19dfd-e339-49c2-95e2-4a07118f1171")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "a5d040ec-e08e-4781-9347-0d8bf0255300")
		private String account;
		@Schema(description = "", example = "2a038a05-a346-43db-b386-c91ab199ed58")
		private String category;
		@Schema(description = "", example = "ddbb4575-5333-4318-bdba-70f7ea7ba937")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
