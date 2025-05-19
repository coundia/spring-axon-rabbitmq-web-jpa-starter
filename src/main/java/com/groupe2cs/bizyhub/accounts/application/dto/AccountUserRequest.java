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

	@Schema(description = "", example = "eb657bc9-cf0f-4c50-9c12-8a13d5f06b80")
	private String name;

	@Schema(description = "", example = "f6ae6eee-1f5e-4973-940b-eff528576435")
	private String account;

	@Schema(description = "", example = "85667012-e1b4-4496-a93a-17dca84b9e18")
	private String user;

	@Schema(description = "", example = "8c69cf9a-8582-446a-8652-91c07d0845e6")
	private String username;

	@Schema(description = "", example = "2ccfa510-c507-4417-a1f4-fde96567f5b9")
	private String details;

	@Schema(description = "", example = "true")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "a81df133-c7ea-4051-b866-5a87d69d114d")
	private String reference;


}
