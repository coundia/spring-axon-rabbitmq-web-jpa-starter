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

		@Schema(description = "", example = "c3422d07-a4dd-4dd6-bdfe-9613f206609c")
		private String account;
		@Schema(description = "", example = "70842ca7-de2a-41f1-8dd4-a251322993dc")
		private String user;
		@Schema(description = "", example = "aca662a5-7e82-4f11-a6e8-07e114aaf0af")
		private String phone;
		@Schema(description = "", example = "ceedc9b2-de8f-4dc0-a84a-267693c8514e")
		private String role;
		@Schema(description = "", example = "89fdbede-c059-46d4-8d2c-2cc2b4b39b15")
		private String status;
		@Schema(description = "", example = "b5ba99ad-f362-4f3a-a3d5-5db50bce60b2")
		private String invitedBy;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant acceptedAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant revokedAt;
		@Schema(description = "", example = "8befd560-c0c8-4773-8d3c-4a557b0968d7")
		private String message;
		@Schema(description = "", example = "73a95e1c-128b-41dc-8971-0e2fd53ad0e3")
		private String remoteId;
		@Schema(description = "", example = "04e264bf-8feb-49ab-8388-327763befb32")
		private String localId;
		@Schema(description = "", example = "false")
		private Boolean isActive;

}
