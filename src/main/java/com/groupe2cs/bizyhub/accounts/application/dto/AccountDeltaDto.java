package com.groupe2cs.bizyhub.accounts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "AccountDeltaDto", description = "Delta DTO for account changes")
public class AccountDeltaDto implements Serializable {

	@Schema(description = "Identifier of the account", example = "uuid")
	private String id;

	@Schema(description = "Change type: CREATE, UPDATE, DELETE, default CREATE", example = "CREATE")
	@Builder.Default
	private String type = "CREATE";

	@Schema(description = "", example = "27109757-af63-4597-bd25-f9a59e7f4715")
	private String name;
	@Schema(description = "", example = "e01f79f8-ae46-4a79-b89b-93bcccee6883")
	private String currency;
	@Schema(description = "", example = "6713.31")
	private Double currentBalance;
	@Schema(description = "", example = "5773.99")
	private Double previousBalance;
	@Schema(description = "", example = "23413d1d-068c-49c8-ab24-77802aa615ac")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
