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

		@Schema(description = "", example = "c64acd52-8dcc-4eb8-a495-38d84b4d0f9f")
		private String sales;
		@Schema(description = "", example = "27e1df1f-342d-4aae-a74f-75278d685de4")
		private String users;
		@Schema(description = "", example = "38e7f4ab-a060-4296-8f3e-aef97e9f38e7")
		private String username;
		@Schema(description = "", example = "16e7b11e-393a-4dd7-b5e7-13091fb7d38f")
		private String email;
		@Schema(description = "", example = "2f54c554-1ff3-4578-abc0-0727eb3330ae")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "0416cd6a-b1af-46be-a06b-5b06666669d2")
		private String reference;

}
