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
@Schema(name = "SaleUserDeltaDto", description = "Delta DTO for saleUser changes")
public class SaleUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the saleUser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "aae529ab-96e9-414e-b1d7-1990281e11a1")
		private String name;
		@Schema(description = "", example = "c67fd432-780a-40e6-9728-9725d0c5d0f0")
		private String sale;
		@Schema(description = "", example = "710d22c7-b7c3-41bf-9a0c-8731258abca6")
		private String user;
		@Schema(description = "", example = "0d2fb33c-f0a2-4335-9093-640f3f894b33")
		private String username;
		@Schema(description = "", example = "fe0f7509-d193-48f2-b237-e08e5f855f8c")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "b53b7e46-e362-4387-8fe9-75add613c3bc")
		private String reference;

}
