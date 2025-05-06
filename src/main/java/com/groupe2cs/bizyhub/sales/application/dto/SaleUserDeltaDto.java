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

		@Schema(description = "", example = "7aa5ba05-ea92-43b0-a192-00e2ed7d3290")
		private String sales;
		@Schema(description = "", example = "bea1dafe-830d-43fc-a3f2-61ae7f649a38")
		private String users;
		@Schema(description = "", example = "5d683294-9f3c-4c8a-8dbf-8539d882fb3a")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "3f9f84af-dd30-47b6-a2ce-8bfcd88cc060")
		private String reference;

}
