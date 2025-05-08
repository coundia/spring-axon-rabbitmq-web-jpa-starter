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

		@Schema(description = "", example = "96e9b814-980b-4f52-82bd-93ce96e3809f")
		private String name;
		@Schema(description = "", example = "c427eff8-019b-46b1-9488-5b6d194be74f")
		private String sale;
		@Schema(description = "", example = "0ba735e9-5677-43e2-936e-4cb2b03cd669")
		private String user;
		@Schema(description = "", example = "911ac469-75ce-4189-92d8-2e658d2a063f")
		private String username;
		@Schema(description = "", example = "3caecd78-9786-4ce0-9ba9-73bd22d995e7")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "c0e01aaf-d64d-4ac7-af8e-254df1791eaf")
		private String reference;

}
