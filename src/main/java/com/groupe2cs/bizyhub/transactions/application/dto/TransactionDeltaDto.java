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

		@Schema(description = "", example = "451cf646-bbe1-48da-a09b-23924cb744e4")
		private String remoteId;
		@Schema(description = "", example = "099c74e5-414c-46e3-8c84-4fde2036767f")
		private String localId;
		@Schema(description = "", example = "02bcb75b-5817-4653-ba71-6e4dbc0a3eb8")
		private String code;
		@Schema(description = "", example = "ba75349f-cb23-49a1-92c5-603ad3d39c80")
		private String description;
		@Schema(description = "", example = "9374.88")
		private Double amount;
		@Schema(description = "", example = "4416c5a0-8a84-4a3d-a746-66baa0a84941")
		private String typeEntry;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "80667d1c-2c74-4576-a68f-5942204a1f41")
		private String status;
		@Schema(description = "", example = "e234ce69-0413-42ac-96a1-ce51eb1968f2")
		private String entityName;
		@Schema(description = "", example = "bb6a43a5-24f7-4e37-864b-9c0b85d406e3")
		private String entityId;
		@Schema(description = "", example = "38924233-eae8-477d-a1ef-077fcae27818")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "34539ca3-bbe3-44da-bb4b-f38a54ff3d86")
		private String category;
		@Schema(description = "", example = "33fd90f0-9fef-4947-88b6-d10afecf7d15")
		private String company;
		@Schema(description = "", example = "7fc7772c-b601-4871-9b65-5a305231dd52")
		private String customer;
		@Schema(description = "", example = "b87af01f-0d29-4317-8baa-5bc425329e6c")
		private String debt;

}
