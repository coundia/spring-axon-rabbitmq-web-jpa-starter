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

	@Schema(description = "", example = "b70e01e1-5a1f-410b-8871-910c2baa0a3c")
	private String user;

	@Schema(description = "", example = "63c9768c-57a5-4a9d-865d-902ef4f8ca7e")
	private String role;


}
