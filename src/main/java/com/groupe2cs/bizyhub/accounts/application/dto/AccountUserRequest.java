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

	@Schema(description = "", example = "ac0fbf80-5f18-4ea9-9a6d-5ed3c7f15cfc")
	private String name;
	@Schema(description = "", example = "b0b61a3b-f784-4db5-a2c0-ee6a3f7f7ba1")
	private String account;
	@Schema(description = "", example = "85564344-822f-457c-b63e-fb22172a03f9")
	private String user;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "a3f6dc18-e4b4-412e-8184-79300780ef18")
	private String username;
	@Schema(description = "", example = "29bf788b-5cf7-4cc3-ba09-35a6f4a881b0")
	private String details;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
