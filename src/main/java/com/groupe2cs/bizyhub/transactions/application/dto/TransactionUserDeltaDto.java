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

		@Schema(description = "", example = "d75be068-0ad8-4228-93a0-230c7a1713b9")
		private String name;
		@Schema(description = "", example = "8e2a1e5f-d1d8-4093-8c31-303239a24320")
		private String transaction;
		@Schema(description = "", example = "03a41438-9742-4d39-aa1b-c4729215eda0")
		private String user;
		@Schema(description = "", example = "272a48e0-425e-4c8d-8ac9-766a56b4065e")
		private String username;
		@Schema(description = "", example = "5f04a697-0f0c-46c7-ab69-63bf3f0136f3")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "a6c685b1-a0eb-471c-8b13-ad044bc99ce6")
		private String reference;

}
