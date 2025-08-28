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

		@Schema(description = "", example = "435b74cf-6ed3-4e88-b456-046ea00508ff")
		private String account;
		@Schema(description = "", example = "865d36ce-29f1-4e71-9644-e507094e40c4")
		private String user;
		@Schema(description = "", example = "21ce7cbd-2110-46c1-9055-cd38b488db79")
		private String identity;
		@Schema(description = "", example = "e5495448-0867-4abf-91df-0dd2e0a5c513")
		private String phone;
		@Schema(description = "", example = "9b9ffe3b-db8e-4758-8764-c9f72b28dcc5")
		private String email;
		@Schema(description = "", example = "74b02617-cc35-4303-a831-08a17174139a")
		private String role;
		@Schema(description = "", example = "66a06591-cc77-4e74-a78e-691d3cf1a24c")
		private String status;
		@Schema(description = "", example = "dcc85ae6-778d-4f45-9f44-fbe159ac9ba7")
		private String invitedBy;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant syncAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant acceptedAt;
		@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
		private java.time.Instant revokedAt;
		@Schema(description = "", example = "abdf5982-0922-41b7-be44-52bbedccb228")
		private String message;
		@Schema(description = "", example = "46877d3f-cdcf-4286-ad8e-790c3cf50434")
		private String remoteId;
		@Schema(description = "", example = "74cae091-d702-4cb7-830e-e69c0038f9ed")
		private String localId;
		@Schema(description = "", example = "true")
		private Boolean isActive;

}
