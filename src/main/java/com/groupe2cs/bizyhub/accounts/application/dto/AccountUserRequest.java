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

	@Schema(description = "", example = "57682397-e86b-4e00-9fe5-0abd56480d56")
	private String name;
	@Schema(description = "", example = "c6f2d468-335f-4e33-bf5a-b577a67d511e")
	private String account;
	@Schema(description = "", example = "91fe13b2-a730-402b-80ba-ecf85b0ced45")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "f9dacb10-e052-44a4-9b8a-97d9cbfe8ada")
	private String username;
	@Schema(description = "", example = "5d7c7676-76b8-4df9-acbf-1ff3e91f55a0")
	private String details;
	@Schema(description = "", example = "1dbef62e-34a8-4cba-a4a8-a24f8b3ad556")
	private String remoteId;
	@Schema(description = "", example = "36c0bd62-5388-419c-93af-075873640766")
	private String localId;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
