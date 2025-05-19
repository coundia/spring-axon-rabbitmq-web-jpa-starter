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

		@Schema(description = "", example = "be532b0e-bed6-44ac-aaa6-dbe2d0f69697")
		private String name;
		@Schema(description = "", example = "5dde78e0-57ee-4e7c-b6a0-41030b4cb377")
		private String account;
		@Schema(description = "", example = "7eeaf238-c8a6-416a-8e3a-ad0518d3bd3c")
		private String user;
		@Schema(description = "", example = "8ce67469-174e-4299-8c4a-9ffdb7d8cb2e")
		private String username;
		@Schema(description = "", example = "6dcbe0e0-f85e-4936-ab49-1b19bdb7f688")
		private String details;
		@Schema(description = "", example = "true")
		private Boolean isActive;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant updatedAt;
		@Schema(description = "", example = "6efb9351-bd04-4b4e-8756-a9264e41b656")
		private String reference;

}
