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

		@Schema(description = "", example = "9f7893f6-1954-44c7-b2db-dc20d2466ca4")
		private String sales;
		@Schema(description = "", example = "68ff16ff-998d-404d-a4fd-52e928c0aa06")
		private String users;
		@Schema(description = "", example = "6bc72ceb-dcde-4f9c-806c-b1bca671fc78")
		private String username;
		@Schema(description = "", example = "ea1bcfa4-1849-491f-a0e4-30818445fc32")
		private String email;
		@Schema(description = "", example = "b4728c08-c9ba-47ed-a952-d14806214fc9")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "8e323831-5dc5-4a63-ab29-cf084398a872")
		private String reference;

}
