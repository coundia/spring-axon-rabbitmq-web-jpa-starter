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

		@Schema(description = "", example = "7098a8fa-a233-46fc-a852-8090c5658305")
		private String name;
		@Schema(description = "", example = "3848158b-a667-4045-b36c-08fe3582bb6e")
		private String transaction;
		@Schema(description = "", example = "975f1f2e-e91a-4dee-af25-9a64069dc87e")
		private String user;
		@Schema(description = "", example = "76d47423-3bba-4edc-b5bb-c9d47c8de5ba")
		private String username;
		@Schema(description = "", example = "e606c1b5-43f3-4076-aff9-2bb12b003992")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "31867844-1e57-4638-bd58-2a6e3eee8f0b")
		private String reference;

}
