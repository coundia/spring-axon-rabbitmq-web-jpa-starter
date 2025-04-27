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

	@Schema(description = "", example = "8b4e3ddf-75af-43b9-b878-61a65410f668")
	private String user;

	@Schema(description = "", example = "3a95dd2c-478e-441b-b366-acacc80d16f6")
	private String role;


}
