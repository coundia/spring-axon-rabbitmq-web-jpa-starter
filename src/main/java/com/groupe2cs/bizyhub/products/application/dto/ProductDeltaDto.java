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

		@Schema(description = "", example = "749f683d-c46a-4e5a-a038-1f9f6666935a")
		private String name;
		@Schema(description = "", example = "8288.52")
		private Double price;
		@Schema(description = "", example = "c97d737d-431b-46e3-a0ab-779fef983378")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "a59ae1e1-e84f-44c9-a7c0-0b8b652d31b5")
		private String reference;

}
