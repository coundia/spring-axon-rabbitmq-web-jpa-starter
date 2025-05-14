package com.groupe2cs.bizyhub.accounts.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "AccountUserRequest", description = "Request payload for AccountUser operations")
public class AccountUserRequest implements Serializable {

	@Schema(description = "", example = "955a9ef9-f86d-4cce-912d-6fe56d17a67a")
	private String name;

	@Schema(description = "", example = "81d1f106-f0b8-494e-8c18-1356e54e94b3")
	private String account;

	@Schema(description = "", example = "f13738af-16a9-40f2-b958-0f1f2e33cf34")
	private String user;

	@Schema(description = "", example = "26b747e6-76eb-4e65-a3d0-e0de971a7d1e")
	private String username;

	@Schema(description = "", example = "c9237d6b-8a11-4098-abf0-9564c8a71542")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "cbb5929f-a5a3-4c6d-916d-8aeb36152696")
	private String reference;


}
