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

	@Schema(description = "", example = "a714f91f-8789-4b71-a879-9a3efe65ddd2")
	private String user;

	@Schema(description = "", example = "aa0c30dd-e491-4b69-a26a-ee9f222ec3a8")
	private String role;


}
