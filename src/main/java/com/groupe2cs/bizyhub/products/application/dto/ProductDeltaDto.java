package com.groupe2cs.bizyhub.products.application.dto;

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
@Schema(name = "ProductDeltaDto", description = "Delta DTO for product changes")
public class ProductDeltaDto implements Serializable {

    @Schema(description = "Identifier of the product", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "dd6daa8b-09e7-453a-8767-9043a24cdbf3")
		private String name;
		@Schema(description = "", example = "3741.0")
		private Double price;
		@Schema(description = "", example = "c4d25a58-1e2a-4389-8186-8eacd8853f55")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "6a432c25-7904-4c34-bf67-b73ac5fb3f01")
		private String reference;

}
