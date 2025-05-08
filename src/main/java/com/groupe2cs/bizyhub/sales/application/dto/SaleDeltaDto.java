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

		@Schema(description = "", example = "57100176-6319-47b7-aa56-08b669289d9d")
		private String name;
		@Schema(description = "", example = "229.47")
		private Double amount;
		@Schema(description = "", example = "f2c072e8-9e63-4b14-a337-aa1a22fa9c02")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "b82a9359-964e-47ea-97be-eeea7c027c21")
		private String account;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "fb493a81-b952-438f-90c8-50a3b2266e75")
		private String reference;

}
