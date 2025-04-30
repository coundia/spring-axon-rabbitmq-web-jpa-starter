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

	@Schema(description = "", example = "a82e1e56-762c-40a8-ac5f-2d69a267ff50")
	private String user;

	@Schema(description = "", example = "da4dc403-ef50-4016-a1db-aabb6037f158")
	private String role;


}
