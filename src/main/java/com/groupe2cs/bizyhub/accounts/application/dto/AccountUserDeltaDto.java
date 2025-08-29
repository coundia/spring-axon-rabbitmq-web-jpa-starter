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

		@Schema(description = "", example = "c809c858-7ffb-41f8-88a8-05542a586006")
		private String account;
		@Schema(description = "", example = "742fde91-8c58-4842-a08e-c123004dca86")
		private String user;
		@Schema(description = "", example = "90eeb8dc-ee1a-47e7-93be-ace24fc8f96f")
		private String identity;
		@Schema(description = "", example = "1079e61c-b2a7-4b72-9f00-a6562406c24a")
		private String phone;
		@Schema(description = "", example = "38ad0f3d-531e-4c38-a8dc-a286ab8bf755")
		private String email;
		@Schema(description = "", example = "3ef1990a-64e3-4dfa-946f-796f9ac2d7f9")
		private String role;
		@Schema(description = "", example = "51c8fa3d-3e6b-483e-88f8-cf2e528c5602")
		private String status;
		@Schema(description = "", example = "d647647b-c5e5-4898-8cab-9f8dd2ba94b1")
		private String invitedBy;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant acceptedAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant revokedAt;
		@Schema(description = "", example = "d1f662b3-d13d-44aa-b3b1-593634f34b24")
		private String message;
		@Schema(description = "", example = "bcc018cc-df29-4583-ba9e-07ceb896c44f")
		private String remoteId;
		@Schema(description = "", example = "21f9877c-82a8-404f-b9f2-62314aa5692d")
		private String localId;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
