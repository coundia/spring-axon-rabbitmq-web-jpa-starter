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

		@Schema(description = "", example = "74fd3fef-56db-4814-84c1-49f012d4742d")
		private String transaction;
		@Schema(description = "", example = "027270cf-48d5-4caf-913b-580f2fc805f5")
		private String product;
		@Schema(description = "", example = "b9fb79bd-34b0-4bd0-97df-040e5041bbca")
		private String label;
		@Schema(description = "", example = "36")
		private Integer quantity;
		@Schema(description = "", example = "609a7e5e-9753-43c9-b45f-adec654d1d83")
		private String unit;
		@Schema(description = "", example = "6acc3274-223a-49e5-9ab4-8e20e41f3792")
		private String account;
		@Schema(description = "", example = "153eac33-0144-4f1c-846b-32b677d9a189")
		private String remoteId;
		@Schema(description = "", example = "4f1285c5-f1c3-4489-8edc-926e627c692e")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "580.81")
		private Double unitPrice;
		@Schema(description = "", example = "8356.8")
		private Double total;
		@Schema(description = "", example = "52c7af21-50fa-4e47-8dd2-2f9bf5444087")
		private String notes;

}
