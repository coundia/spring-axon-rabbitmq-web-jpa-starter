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

		@Schema(description = "", example = "e3cac8ea-d462-4158-8282-581c61e78039")
		private String account;
		@Schema(description = "", example = "e2845eaf-1c92-4562-9731-6bfb2cde6ea3")
		private String user;
		@Schema(description = "", example = "8b1251fc-feca-4315-a8ec-35e038c12aaa")
		private String identity;
		@Schema(description = "", example = "b276650e-31de-4acf-94cd-23430f5012a5")
		private String phone;
		@Schema(description = "", example = "cf5b7ef8-947f-4822-a43d-16e2e204cbd1")
		private String email;
		@Schema(description = "", example = "4b13cedd-9f35-4931-ae5a-2528d38abd11")
		private String role;
		@Schema(description = "", example = "5c35b2e0-7b17-4670-b347-33c819f5410e")
		private String status;
		@Schema(description = "", example = "6ad4b05e-cc41-46a9-8b42-448156edc355")
		private String invitedBy;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant acceptedAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant revokedAt;
		@Schema(description = "", example = "0b63d3af-f93c-48dc-b3d9-8a99eed2132f")
		private String message;
		@Schema(description = "", example = "6c0245fc-ddfa-4a03-b6e7-f060a8efba7b")
		private String remoteId;
		@Schema(description = "", example = "d1803166-19f6-4ff8-8e99-9009fe4ff472")
		private String localId;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
