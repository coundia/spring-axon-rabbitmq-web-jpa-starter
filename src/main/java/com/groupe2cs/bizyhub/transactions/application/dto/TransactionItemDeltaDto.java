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
@Schema(name = "TransactionItemDeltaDto", description = "Delta DTO for transactionItem changes")
public class TransactionItemDeltaDto implements Serializable {

    @Schema(description = "Identifier of the transactionItem", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "d3e48ae4-c1b7-4399-b3eb-257e5747eaa0")
		private String transaction;
		@Schema(description = "", example = "35b5e6a3-a729-4f45-b587-6cecfb0ef216")
		private String product;
		@Schema(description = "", example = "fc676e65-401b-4cf3-8d95-e4858dd1e4d4")
		private String label;
		@Schema(description = "", example = "69")
		private Integer quantity;
		@Schema(description = "", example = "a9bf60ec-6706-49dc-985f-0d9301abe76e")
		private String unit;
		@Schema(description = "", example = "9a84f9f1-9ac4-45f6-a80c-5da630b4d63a")
		private String remoteId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "2606.02")
		private Double unitPrice;
		@Schema(description = "", example = "1535.55")
		private Double total;
		@Schema(description = "", example = "5fca1215-3a8e-43c1-8612-1d25471140a3")
		private String notes;

}
