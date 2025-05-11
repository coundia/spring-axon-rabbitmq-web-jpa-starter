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

		@Schema(description = "", example = "b96c8f46-8acf-4520-ab04-4020b749df97")
		private String name;
		@Schema(description = "", example = "2b4cb7bb-e9fb-46fa-bd88-1f618855b7ab")
		private String transaction;
		@Schema(description = "", example = "878a9f7d-41f8-49cc-a76c-74ad67a4223f")
		private String user;
		@Schema(description = "", example = "343c5cc2-d929-4572-936d-93dd98d0838e")
		private String username;
		@Schema(description = "", example = "5a11bdaf-07d7-44fb-90ca-a53877f407d1")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "65f780ef-22b6-4bf5-9065-91494d2d6209")
		private String reference;

}
