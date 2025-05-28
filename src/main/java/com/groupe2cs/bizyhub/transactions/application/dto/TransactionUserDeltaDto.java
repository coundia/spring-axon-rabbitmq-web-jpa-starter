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

		@Schema(description = "", example = "cde587a1-2468-4cd3-9ad6-29c855999453")
		private String name;
		@Schema(description = "", example = "66a2e0ae-4623-44a1-a142-a09f00d82c98")
		private String transaction;
		@Schema(description = "", example = "270450b1-0c40-4aef-98e7-887aebb15db5")
		private String user;
		@Schema(description = "", example = "24ac0c20-e110-491a-8006-ed6c99985969")
		private String username;
		@Schema(description = "", example = "136445eb-32b0-470c-ac0d-c349b6ee3317")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
