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

		@Schema(description = "", example = "3f3616c3-cedd-4d0f-b646-dd3dab23da45")
		private String name;
		@Schema(description = "", example = "6045.33")
		private Double amount;
		@Schema(description = "", example = "0ee89b5c-b23b-42e4-81b3-3e962b3c36ca")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "f3a42974-52f9-4ca8-b371-f351d9e5d1c7")
		private String reference;

}
