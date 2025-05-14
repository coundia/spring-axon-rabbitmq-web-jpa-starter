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

	@Schema(description = "", example = "dcca03a0-6d22-4768-aa23-3aba52e20323")
	private String name;
	@Schema(description = "", example = "6006bb2e-50b1-4664-b3ec-6f621ea17155")
	private String account;
	@Schema(description = "", example = "e939407d-d2ec-4813-a73e-96d16c826381")
	private String user;
	@Schema(description = "", example = "8f5cd189-ed0d-4315-9427-353e41a6db62")
	private String username;
	@Schema(description = "", example = "fa03debc-3463-4fba-bb40-1f00455c1d3f")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "3bd4c0c5-b399-44b3-ab33-53a7d0ab76aa")
	private String reference;

}
