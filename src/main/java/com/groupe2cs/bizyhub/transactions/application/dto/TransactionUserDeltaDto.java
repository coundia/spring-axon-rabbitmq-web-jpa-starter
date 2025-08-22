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

		@Schema(description = "", example = "8532a8db-2ed8-4699-880b-b18fde3944db")
		private String name;
		@Schema(description = "", example = "9bdc38e0-a165-4842-b146-c012071ffa3f")
		private String transaction;
		@Schema(description = "", example = "9bcb56e2-4887-4a60-a5c3-b01fc3a1db1c")
		private String user;
		@Schema(description = "", example = "05d5dffd-ecf7-4079-a660-35340bd0e66d")
		private String username;
		@Schema(description = "", example = "13a2127f-ea53-431e-bcdd-b62fadb1bcb5")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
