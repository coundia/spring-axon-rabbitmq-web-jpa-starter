package com.groupe2cs.bizyhub.accounts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

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

	@Schema(description = "", example = "352eacdb-73f2-4d9f-9e78-b9498b6303c0")
	private String name;
	@Schema(description = "", example = "ebd81e1c-de72-43e8-ba30-e7723c397bc9")
	private String account;
	@Schema(description = "", example = "96a4ed31-1e6e-4e90-88b7-4e42bec79064")
	private String user;
	@Schema(description = "", example = "23ab8524-de8a-48e9-861a-921e7476c638")
	private String username;
	@Schema(description = "", example = "e3042421-115d-4a68-bcac-4c308dedc3d3")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "3e62d4b6-7a80-45df-b39a-376abbe6d62b")
	private String reference;

}
