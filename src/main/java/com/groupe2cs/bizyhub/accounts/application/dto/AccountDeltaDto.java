package com.groupe2cs.bizyhub.accounts.application.dto;

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
@Schema(name = "AccountDeltaDto", description = "Delta DTO for account changes")
public class AccountDeltaDto implements Serializable {

    @Schema(description = "Identifier of the account", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "2458b4b3-5fe1-48fa-a66e-674abd145a6c")
		private String name;
		@Schema(description = "", example = "513edd8d-df06-4366-8cc7-273a45a43a4b")
		private String currency;
		@Schema(description = "", example = "8154.06")
		private Double currentBalance;
		@Schema(description = "", example = "5349.26")
		private Double previousBalance;
		@Schema(description = "", example = "7fd0ba92-48ca-4e35-b2a1-482de3694a96")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
