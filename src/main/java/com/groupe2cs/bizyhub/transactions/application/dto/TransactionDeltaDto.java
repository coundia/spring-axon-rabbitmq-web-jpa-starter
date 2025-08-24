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

		@Schema(description = "", example = "054ec7ce-86f7-45d7-9627-8bbefa35070f")
		private String name;
		@Schema(description = "", example = "4309.2")
		private Double amount;
		@Schema(description = "", example = "301438df-08bd-48da-b90f-e58f04fbc347")
		private String remoteId;
		@Schema(description = "", example = "ab4164bd-2f8a-4c59-b694-f23e0a28b841")
		private String localId;
		@Schema(description = "", example = "5e29128f-d003-4e03-9e3d-67b75e41b6e9")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "f23cdf38-68b4-425f-8daa-38b2ced1ec74")
		private String account;
		@Schema(description = "", example = "476ef48f-7fde-4db6-be5d-51fe457b3027")
		private String category;
		@Schema(description = "", example = "df129f12-1b3c-41bd-b504-ed67397d7cae")
		private String typeEntry;
		@Schema(description = "", example = "fbca5fca-94e4-4067-a04f-3c9129703b48")
		private String typeTransactionRaw;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;

}
