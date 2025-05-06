package com.groupe2cs.bizyhub.sales.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "SaleDeltaDto", description = "Delta DTO for sale changes")
public class SaleDeltaDto implements Serializable {

    @Schema(description = "Identifier of the sale", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "79e29ee5-e79b-4ac4-a17a-102efd6c0305")
		private String name;
		@Schema(description = "", example = "6199.22")
		private Double amount;
		@Schema(description = "", example = "d26c4269-9026-49d5-8c8e-ac2ff35191bc")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "7374d3cf-e75a-4bc8-b6be-2004e96ab355")
		private String product;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "966935b8-3ff8-4b50-a3ca-6d20dca817f3")
		private String reference;

}
