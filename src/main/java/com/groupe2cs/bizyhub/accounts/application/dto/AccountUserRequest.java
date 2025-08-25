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

	@Schema(description = "", example = "66a226a8-ac70-4774-8e5c-0204ad4f89d6")
	private String name;
	@Schema(description = "", example = "8044f2ba-e233-4a9c-bffe-7b97c4c59f50")
	private String account;
	@Schema(description = "", example = "05e5b107-bc59-4b1a-9e76-cad0833bad81")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "bae998ea-a342-4563-9236-c78826031a3e")
	private String username;
	@Schema(description = "", example = "54398424-d1b4-495d-b9e2-9fb77d9714c5")
	private String details;
	@Schema(description = "", example = "f8b1632e-8c1a-4c70-8b9d-53d9df73f042")
	private String remoteId;
	@Schema(description = "", example = "bd5a08ed-935e-4441-bd9b-659f6b4d0a8f")
	private String localId;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
