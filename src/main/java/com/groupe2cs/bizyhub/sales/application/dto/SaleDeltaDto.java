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

		@Schema(description = "", example = "a273dc33-97a8-4492-bc57-3324989cbdb3")
		private String name;
		@Schema(description = "", example = "3707.66")
		private Double amount;
		@Schema(description = "", example = "829dbf15-7ead-4083-8b8c-1e347e98ee26")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "2c062936-438a-457c-b6f5-000284d014e7")
		private String product;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "777978d4-bf9a-4ea2-9339-fa2a2cc7cf5c")
		private String reference;

}
