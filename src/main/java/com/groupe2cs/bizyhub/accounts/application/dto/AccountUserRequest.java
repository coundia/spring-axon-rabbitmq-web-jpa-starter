package com.groupe2cs.bizyhub.accounts.application.dto;

import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import java.util.UUID;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "AccountUserRequest", description = "Request payload for AccountUser operations")
public class AccountUserRequest implements Serializable {

	@Schema(description = "", example = "3486908a-501d-4481-be04-a44d02e9a17f")
	private String account;
	@Schema(description = "", example = "33881a13-d7b6-4d27-8094-c36b76aca619")
	private String user;
	@Schema(description = "", example = "d89bc096-3614-4f6b-9a18-f67610c66087")
	private String phone;
	@Schema(description = "", example = "99da806d-db0d-438b-b64f-7a7bc43e9947")
	private String role;
	@Schema(description = "", example = "0af2d7f4-1d51-4ae2-9c42-ad399249bda0")
	private String status;
	@Schema(description = "", example = "50b83eee-7d8f-4570-b392-9918f88239a5")
	private String invitedBy;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant acceptedAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant revokedAt;
	@Schema(description = "", example = "42cb140e-78ba-4670-adf1-2dde42d6080e")
	private String message;
	@Schema(description = "", example = "593003d2-afcf-4153-8058-e46f8e87030f")
	private String remoteId;
	@Schema(description = "", example = "cdc88408-ff2f-4e35-a67e-d71332fa50ed")
	private String localId;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
