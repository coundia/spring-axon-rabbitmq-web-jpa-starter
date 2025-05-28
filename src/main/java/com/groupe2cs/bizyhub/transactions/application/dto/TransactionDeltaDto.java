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

		@Schema(description = "", example = "05474df5-51e1-4185-a2e1-b45c59812e26")
		private String name;
		@Schema(description = "", example = "2857.12")
		private Double amount;
		@Schema(description = "", example = "819c8703-b99b-420b-87e1-35d92f9c53a8")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "0d299bf7-b346-4516-8db3-4c23c2892284")
		private String account;
		@Schema(description = "", example = "11792a71-e7c7-4019-95fe-d7301859fbcb")
		private String category;
		@Schema(description = "", example = "f8d1a6cb-fe91-4bcc-b1fc-ce61dded3681")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
