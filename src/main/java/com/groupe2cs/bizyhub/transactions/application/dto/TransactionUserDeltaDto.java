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

		@Schema(description = "", example = "9613b07a-1a76-4a8f-a772-90b348ddc35e")
		private String name;
		@Schema(description = "", example = "d720e596-f7e7-4306-b4dd-9a12663ccdf1")
		private String remoteId;
		@Schema(description = "", example = "3da25248-fe28-4385-8788-356225c84ca0")
		private String localId;
		@Schema(description = "", example = "2229c6b3-8c22-4452-8a5f-d414c35b6330")
		private String transaction;
		@Schema(description = "", example = "5691f15e-4369-439c-8b9e-0b15f0f102cc")
		private String user;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "93e83fa3-8a43-4ef1-bb36-b146806b6e6f")
		private String username;
		@Schema(description = "", example = "8c897f51-4fc7-4e35-8588-c3effd31b68e")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
