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

		@Schema(description = "", example = "57d53a77-eb23-4716-beaa-6b908a40cb2e")
		private String transaction;
		@Schema(description = "", example = "ad2f5e67-9d8e-40b4-922f-84a5a5163da7")
		private String product;
		@Schema(description = "", example = "efca599a-5ea7-4028-9be4-718c3876b575")
		private String label;
		@Schema(description = "", example = "21")
		private Integer quantity;
		@Schema(description = "", example = "c28aa3b4-805c-40e7-abaa-9f6b9c9e423d")
		private String unit;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "3341.99")
		private Double unitPrice;
		@Schema(description = "", example = "723.16")
		private Double total;
		@Schema(description = "", example = "d32e7494-def3-4e44-955c-84136e453b13")
		private String notes;

}
