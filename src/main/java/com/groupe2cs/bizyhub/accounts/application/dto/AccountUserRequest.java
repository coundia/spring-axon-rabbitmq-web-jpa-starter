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

	@Schema(description = "", example = "5dc220f6-684c-497d-aed9-816c2e68c09d")
	private String account;
	@Schema(description = "", example = "72a094c2-609b-4a17-b8fb-5e9ae3295906")
	private String user;
	@Schema(description = "", example = "4daa1c31-7efd-424d-bcd2-5d8b3d4744bf")
	private String identity;
	@Schema(description = "", example = "9d82dd5c-6047-445a-bbf7-63c818fc3cbd")
	private String phone;
	@Schema(description = "", example = "851019f3-a1e8-43b8-8769-55c544fe0ef4")
	private String email;
	@Schema(description = "", example = "fd3f98ab-7103-4dd8-bb86-2996a2c20a61")
	private String role;
	@Schema(description = "", example = "2e3f591f-52f0-44a7-a223-9a007e84dd05")
	private String status;
	@Schema(description = "", example = "9ec3aefd-4b2b-4702-8a88-14b43d51d93a")
	private String invitedBy;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant syncAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant acceptedAt;
	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant revokedAt;
	@Schema(description = "", example = "1ec7c753-09a9-49ee-863f-0ae4e790b6b2")
	private String message;
	@Schema(description = "", example = "8fea4efd-33b1-4200-8932-55bf22071481")
	private String remoteId;
	@Schema(description = "", example = "f814f1ad-4529-4865-9e82-07d18780fd29")
	private String localId;
	@Schema(description = "", example = "false")
	private Boolean isActive;

}
