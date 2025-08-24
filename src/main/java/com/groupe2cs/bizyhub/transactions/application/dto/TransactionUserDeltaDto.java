package com.groupe2cs.bizyhub.transactions.application.dto;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(name = "TransactionUserDeltaDto", description = "Delta DTO for transactionUser changes")
public class TransactionUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the transactionUser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "65d16539-fffd-45f4-b173-700039b267ee")
		private String name;
		@Schema(description = "", example = "9a59fa45-e945-41d3-a8b5-17f7941dbeb3")
		private String remoteId;
		@Schema(description = "", example = "741be2f9-e9b2-429f-870c-1df95eb731ef")
		private String transaction;
		@Schema(description = "", example = "7bb759b6-0047-467d-aa56-8947a150a57b")
		private String user;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "33083f28-6660-417b-8e7d-9f2fc6a76273")
		private String username;
		@Schema(description = "", example = "b6294541-fc6d-4ce7-a213-579f2237fae3")
		private String details;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
