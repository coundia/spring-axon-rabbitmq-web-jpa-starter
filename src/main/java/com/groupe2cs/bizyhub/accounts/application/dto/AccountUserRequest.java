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

	@Schema(description = "", example = "7a05f991-f9ab-4992-a590-5168b5923b64")
	private String name;

	@Schema(description = "", example = "0f5cf028-00c9-4ec9-9593-e48f8ad81f02")
	private String account;

	@Schema(description = "", example = "38742bb0-6b02-43b2-a4a3-ab92e9425823")
	private String user;

	@Schema(description = "", example = "78ba1458-162b-4d3d-85fb-9ac3134a8243")
	private String username;

	@Schema(description = "", example = "3e98834d-23af-48c2-94ea-90e733734059")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "cc1b5170-bced-4404-8088-5b377f506565")
	private String reference;


}
