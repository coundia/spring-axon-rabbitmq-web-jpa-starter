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

		@Schema(description = "", example = "68da0feb-125f-4c88-b93a-306d37889d0f")
		private String name;
		@Schema(description = "", example = "1375.93")
		private Double amount;
		@Schema(description = "", example = "fb75a42b-0fcb-40a4-8cf6-a395bc9b11ff")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "ed263d5a-8921-45d5-8913-bc1df3bdf363")
		private String account;
		@Schema(description = "", example = "14e1ac40-9ef8-4e6d-9f41-e8e4c17fd56f")
		private String category;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "ed6894bf-fcef-471d-a1a6-650c1c417249")
		private String reference;

}
