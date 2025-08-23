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

	@Schema(description = "", example = "676af233-2c5c-4957-ab9a-c3e0797dc602")
	private String name;
	@Schema(description = "", example = "ba75a6f6-c587-4766-b5de-60ac21736d20")
	private String account;
	@Schema(description = "", example = "6fc9bcab-28b4-474d-b570-ab6663709dfe")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "4c55b1a0-3738-44fd-9b33-c418974acccd")
	private String username;
	@Schema(description = "", example = "91fc8b71-b0f4-469c-b6dc-48f625a2646c")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
