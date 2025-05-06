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
@Schema(name = "SaleUserDeltaDto", description = "Delta DTO for saleuser changes")
public class SaleUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the saleuser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "fcd3b7c8-485b-42c7-9184-20c57a6aad0b")
		private String sales;
		@Schema(description = "", example = "10b46df9-834d-4f81-88eb-e81f2694f04e")
		private String users;
		@Schema(description = "", example = "4f50ddfc-d9e7-4afe-8ffc-3f4d86e92da7")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "db881b4d-633f-4557-9397-5ad0b70c60f6")
		private String reference;

}
