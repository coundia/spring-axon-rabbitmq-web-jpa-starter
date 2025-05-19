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
@Schema(name = "AccountUserDeltaDto", description = "Delta DTO for accountUser changes")
public class AccountUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the accountUser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "823c3368-e2bf-459f-b780-ec719e2543c7")
		private String name;
		@Schema(description = "", example = "5d02ee4f-cbe9-4cb3-9758-b2178105fa22")
		private String account;
		@Schema(description = "", example = "391fcf8e-1197-4f15-8597-2c0d74fede4a")
		private String user;
		@Schema(description = "", example = "351f8065-85bf-4521-803c-d5a303cf582b")
		private String username;
		@Schema(description = "", example = "0e7f67af-4952-4e83-92dd-09cfe0a971dd")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "6bd0c769-72f5-4e64-9570-866a314f45fb")
		private String reference;

}
