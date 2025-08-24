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
@Schema(name = "TransactionEntryDeltaDto", description = "Delta DTO for transactionEntry changes")
public class TransactionEntryDeltaDto implements Serializable {

    @Schema(description = "Identifier of the transactionEntry", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "a99feba3-97fe-4bae-adb2-3fa3c9195ec0")
		private String remoteId;
		@Schema(description = "", example = "72b4535b-8f78-4458-8fe2-238378b29b4f")
		private String code;
		@Schema(description = "", example = "aa8aae5c-b1bc-4f02-bd76-d5ebc525e564")
		private String description;
		@Schema(description = "", example = "6495.97")
		private Double amount;
		@Schema(description = "", example = "5d97df19-cb70-4942-b6ab-075d46fd82bd")
		private String typeEntry;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant dateTransaction;
		@Schema(description = "", example = "4a7a0163-00c3-4bc7-8a94-d672920cf942")
		private String status;
		@Schema(description = "", example = "469450f7-a01f-4805-b245-1552fa9c9342")
		private String entityName;
		@Schema(description = "", example = "39b46206-7890-42e9-95bc-b6c07b2a9af0")
		private String entityId;
		@Schema(description = "", example = "0db52447-7858-45ea-8d7e-0b592c300fcb")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "fdfcab36-9fa9-45f9-adc8-3bf3416da635")
		private String category;
		@Schema(description = "", example = "417f3008-ad7c-4e58-a0d3-f9fcaa95c57f")
		private String company;
		@Schema(description = "", example = "7c0b1a05-9985-441c-bc25-860bdf0240f0")
		private String customer;
		@Schema(description = "", example = "9745fbae-c4ad-4d40-a34a-a484119b1269")
		private String debt;

}
