package com.groupe2cs.bizyhub.accounts.application.dto;

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
@Schema(name = "AccountUserDeltaDto", description = "Delta DTO for accountUser changes")
public class AccountUserDeltaDto implements Serializable {

    @Schema(description = "Identifier of the accountUser", example = "uuid")
    private String id;

    @Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
    private String type = "CREATE";

		@Schema(description = "", example = "e774f054-5af6-4c51-a903-2decbfae4bf0")
		private String name;
		@Schema(description = "", example = "7d50af46-524f-4c01-bf8c-7520bf05a2f9")
		private String account;
		@Schema(description = "", example = "667e4d68-d7f5-4a7a-a7b4-851c2729f17d")
		private String user;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "c49227cd-af71-45eb-aa0b-1869cee5e2a0")
		private String username;
		@Schema(description = "", example = "3fd816a2-fa5f-4d84-9041-3021f65971e7")
		private String details;
		@Schema(description = "", example = "f7888e5d-54f0-4423-b5e4-94c1b211c45a")
		private String remoteId;
		@Schema(description = "", example = "9a6aefa4-03c7-453c-8650-2f8849506a24")
		private String localId;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
