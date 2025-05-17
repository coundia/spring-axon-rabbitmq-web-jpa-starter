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

	@Schema(description = "", example = "fb922012-5896-49c6-bda5-1d9cf715ee99")
	private String name;
	@Schema(description = "", example = "d3a30300-9090-449f-8b4e-3027e0559f75")
	private String currency;
	@Schema(description = "", example = "5713.98")
	private Double currentBalance;
	@Schema(description = "", example = "1833.41")
	private Double previousBalance;
	@Schema(description = "", example = "e247fe17-6003-4a32-8953-fae7f44985fb")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;
	@Schema(description = "", example = "04fe9cbb-fb25-4fbd-b688-b6948206f2b4")
	private String reference;

}
