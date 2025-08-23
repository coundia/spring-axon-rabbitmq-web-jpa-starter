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

		@Schema(description = "", example = "09a1ed85-8ed2-49a7-816e-9277ffe2f747")
		private String name;
		@Schema(description = "", example = "35dd6cb3-277c-4f01-a7de-79c5f4674544")
		private String transaction;
		@Schema(description = "", example = "c4d30c68-7590-40c3-bfcc-d2804d519e68")
		private String user;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "a571b0e7-c065-44bd-8ea5-09f06c71b2b9")
		private String username;
		@Schema(description = "", example = "ff0530fb-1504-4636-bbad-944efcb6214f")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
