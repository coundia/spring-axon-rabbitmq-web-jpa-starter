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

	@Schema(description = "", example = "1c5b6b62-83ab-4483-b808-bdc1be4deb32")
	private String name;
	@Schema(description = "", example = "7ae60f66-7179-473d-b1f3-fc864480b82c")
	private String account;
	@Schema(description = "", example = "539a205a-9082-416b-9641-7d7a45a1b867")
	private String user;
	@Schema(description = "", example = "8984ede6-4cf1-4b27-b3c4-f5eec336769a")
	private String username;
	@Schema(description = "", example = "d10894d3-ed40-418f-bd96-de6688c1f2ba")
	private String details;
	@Schema(description = "", example = "true")
	private Boolean isActive;

}
