package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "UserRoleRequest", description = "Request payload for UserRole operations")
public class UserRoleRequest implements Serializable {

	@Schema(description = "", example = "87072256-8ebc-4af8-a59f-625eddafccc2")
	private String user;

	@Schema(description = "", example = "67a9a695-1d3e-49fc-8b9a-f86fe9faf016")
	private String role;


}
