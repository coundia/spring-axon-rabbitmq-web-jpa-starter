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

	@Schema(description = "", example = "98567fb6-4734-4e6d-8acb-9ecc8b2ca0c0")
	private String name;

	@Schema(description = "", example = "577f18b4-903e-4c2e-953c-41bd729210cc")
	private String account;

	@Schema(description = "", example = "e7dd7ea0-0a9c-46e7-8ad4-fbad60de023f")
	private String user;

	@Schema(description = "", example = "2351e168-ce88-4499-a474-575d178871a5")
	private String username;

	@Schema(description = "", example = "c6da07fc-9d5e-4dc1-896e-05084eca6f6c")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "1be91091-34dc-4d0e-a549-605e93091380")
	private String reference;


}
