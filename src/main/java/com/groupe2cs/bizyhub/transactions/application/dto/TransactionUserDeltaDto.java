package com.groupe2cs.bizyhub.transactions.application.dto;

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
@Schema(name = "TransactionUserDeltaDto", description = "Delta DTO for transactionUser changes")
public class TransactionUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the transactionUser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "fe6e4c3a-a496-4108-96b9-0da809d26015")
		private String name;
		@Schema(description = "", example = "1eef4b7f-3ccb-45f9-924b-655223c94bad")
		private String transaction;
		@Schema(description = "", example = "a3910191-6005-4b91-81f3-441f89671a3d")
		private String user;
		@Schema(description = "", example = "e1f44a2c-2949-47d5-a33a-2c70dcd6f747")
		private String username;
		@Schema(description = "", example = "cfb624b6-5cde-4c1d-ad79-f14c44053388")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "520e7ae8-df24-4b15-95f3-de59a2227546")
		private String reference;

}
