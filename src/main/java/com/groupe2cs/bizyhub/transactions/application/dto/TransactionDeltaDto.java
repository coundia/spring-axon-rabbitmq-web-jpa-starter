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

		@Schema(description = "", example = "875c49c9-4466-4437-8dcd-03a86df8fc5d")
		private String remoteId;
		@Schema(description = "", example = "745d361f-276d-4ed2-bf63-977615f6c217")
		private String localId;
		@Schema(description = "", example = "28e29ca9-6fc6-4893-b0de-483b9764db98")
		private String code;
		@Schema(description = "", example = "ca1cde95-4fe3-4eef-9bf7-fcf4d1e2d830")
		private String description;
		@Schema(description = "", example = "1229.72")
		private Double amount;
		@Schema(description = "", example = "6ab1a78a-c918-4085-b2a4-7db8eaaa4ecc")
		private String typeEntry;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "b8f431bd-3c38-482e-9e1e-9b5ed92e81f8")
		private String status;
		@Schema(description = "", example = "9e41d62c-b80b-43e4-a9ff-69322e95806c")
		private String entityName;
		@Schema(description = "", example = "85363178-e88d-40ac-850b-98836a321558")
		private String entityId;
		@Schema(description = "", example = "1a597336-ead8-4125-acb6-d3a2005476ac")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "4254598b-3644-4a16-8c78-109d8a27e9fb")
		private String category;
		@Schema(description = "", example = "23aa3ec4-77a8-45d0-b56a-e1ce9c234ab7")
		private String company;
		@Schema(description = "", example = "80e1c692-f952-4029-8f55-2c478dbb78e8")
		private String customer;
		@Schema(description = "", example = "fa1329c4-d514-45ce-b712-7ed150939920")
		private String debt;

}
