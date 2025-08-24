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

		@Schema(description = "", example = "6c64e1a9-2dce-44a6-9ff7-d42ee8b844dd")
		private String transaction;
		@Schema(description = "", example = "df364fff-ef90-4644-97f0-cecf53342101")
		private String product;
		@Schema(description = "", example = "0b2201ad-49d9-4121-9e51-a94cfd7ae0fa")
		private String label;
		@Schema(description = "", example = "7")
		private Integer quantity;
		@Schema(description = "", example = "9958607f-3019-4439-b606-37f7eb426d97")
		private String unit;
		@Schema(description = "", example = "97aae139-396f-4b00-aa36-6323fd6df87c")
		private String remoteId;
		@Schema(description = "", example = "911e89a6-51ca-4123-a300-c7c36e72cb40")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "1771.46")
		private Double unitPrice;
		@Schema(description = "", example = "4785.02")
		private Double total;
		@Schema(description = "", example = "8d435d02-86c6-4d6d-b9e0-00c86c529200")
		private String notes;

}
