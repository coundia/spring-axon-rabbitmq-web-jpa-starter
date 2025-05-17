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

	@Schema(description = "", example = "b7b0c55b-7d6d-4e83-b5e9-0376ee957e9d")
	private String name;

	@Schema(description = "", example = "4baf7316-feb1-454f-a9ad-34d84631a352")
	private String account;

	@Schema(description = "", example = "006ccaa7-7de5-41d6-b6bc-f10e37e9d68b")
	private String user;

	@Schema(description = "", example = "50e06d8f-83cb-4c77-a763-dec996d4aac3")
	private String username;

	@Schema(description = "", example = "01dfad08-85f6-4527-9100-df5fefe5f0ac")
	private String details;

	@Schema(description = "", example = "false")
	private Boolean isActive;

	@Schema(description = "", example = "java.time.Instant.now().plusSeconds(3600)")
	private java.time.Instant updatedAt;

	@Schema(description = "", example = "690ca7d0-6ec1-44cf-ad25-92a9802bb3b8")
	private String reference;


}
