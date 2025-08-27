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

		@Schema(description = "", example = "1d6e2f50-66be-4dda-b118-269ab7d2c760")
		private String transaction;
		@Schema(description = "", example = "b163fafb-fed1-405e-99e8-d5e974605450")
		private String product;
		@Schema(description = "", example = "1a338df4-f22d-4655-a501-1b0100f7d359")
		private String label;
		@Schema(description = "", example = "92")
		private Integer quantity;
		@Schema(description = "", example = "bd06ce1d-a793-414e-8f0e-2d59d73edcab")
		private String unit;
		@Schema(description = "", example = "83908f5f-3509-4f13-90c9-8fa100481816")
		private String remoteId;
		@Schema(description = "", example = "72d2ef3a-6610-4348-82bc-f539d0d670b3")
		private String localId;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "2403.94")
		private Double unitPrice;
		@Schema(description = "", example = "3129.49")
		private Double total;
		@Schema(description = "", example = "8844dfba-3fd6-4704-95c7-6a910e48c657")
		private String notes;

}
