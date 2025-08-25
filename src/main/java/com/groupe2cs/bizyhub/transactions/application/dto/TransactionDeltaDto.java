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

		@Schema(description = "", example = "8a59d4f5-0a1a-4d9f-a11a-443a6719baec")
		private String remoteId;
		@Schema(description = "", example = "5fb33cc9-09ba-48d8-923f-f10564741a0a")
		private String localId;
		@Schema(description = "", example = "88b0d2c7-c08f-4781-ace7-36863b795383")
		private String code;
		@Schema(description = "", example = "80e372f9-04af-4c68-961a-cbe633a0cc57")
		private String description;
		@Schema(description = "", example = "7036.89")
		private Double amount;
		@Schema(description = "", example = "660b18f0-bc1e-430e-98b1-5cb1ddeb7cd7")
		private String typeEntry;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "cd87c072-8fa6-4c7c-982e-c0bb5b3586b0")
		private String status;
		@Schema(description = "", example = "425e5909-e33a-471a-8445-98e06c763478")
		private String entityName;
		@Schema(description = "", example = "5728dddf-0a47-43cc-bc2f-cb63eee8ddba")
		private String entityId;
		@Schema(description = "", example = "b955a9d8-57e8-4c46-b2f1-63369405c6a5")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "dddd175f-c19f-4eb9-886b-da4d2559e3f8")
		private String category;
		@Schema(description = "", example = "5d469d38-a78c-4da3-9a17-5fa8cac1f917")
		private String company;
		@Schema(description = "", example = "3cd95056-6d16-4be8-b9b8-95d8b8120e57")
		private String customer;
		@Schema(description = "", example = "1397f604-0b1e-4d93-9d5b-02b107cdd2f2")
		private String debt;

}
