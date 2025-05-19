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

		@Schema(description = "", example = "d38b7b9e-1a36-465b-9344-96d975132b01")
		private String name;
		@Schema(description = "", example = "759d161b-3086-4b57-80ad-2a2f3e960340")
		private String transaction;
		@Schema(description = "", example = "4fba786b-63aa-4b94-a3b6-7c6e5f7e97f3")
		private String user;
		@Schema(description = "", example = "76bf068d-db1d-408b-be09-6461444bdfed")
		private String username;
		@Schema(description = "", example = "322f3b43-186b-49e2-a0d5-68d2ac519ba0")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "78e7f636-3471-45cb-8934-54bc5c26c822")
		private String reference;

}
