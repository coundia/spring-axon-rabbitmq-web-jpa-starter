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

		@Schema(description = "", example = "38f108a2-b2fc-496c-a688-5ec4167f4a6c")
		private String name;
		@Schema(description = "", example = "b0cdcf61-69be-46cf-9a96-fd7824008586")
		private String account;
		@Schema(description = "", example = "715acd35-b22f-4503-85c4-e2f276a1b631")
		private String user;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "3a9ea6d8-4c6c-44f3-baaf-025decaef3d4")
		private String username;
		@Schema(description = "", example = "7ac47ddf-83a6-4433-9f49-6ac9af7fb16b")
		private String details;
		@Schema(description = "", example = "cabdb87a-b3e6-4dae-a570-e67459ba16d1")
		private String remoteId;
		@Schema(description = "", example = "3da4b8a9-7fcd-4c43-ad0c-85bda3094e85")
		private String localId;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
