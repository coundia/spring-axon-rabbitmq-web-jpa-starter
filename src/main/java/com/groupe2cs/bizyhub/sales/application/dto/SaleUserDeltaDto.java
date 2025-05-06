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

		@Schema(description = "", example = "7e8a7e30-6cf3-41d8-970a-92cae4f0a142")
		private String sales;
		@Schema(description = "", example = "2217eb61-22c1-4ebe-a04c-dd7a871c0eab")
		private String users;
		@Schema(description = "", example = "8498b923-f5fa-41c7-8dec-982f87020035")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "60194abf-a2ed-41dc-876f-c2a287abb3a5")
		private String reference;

}
