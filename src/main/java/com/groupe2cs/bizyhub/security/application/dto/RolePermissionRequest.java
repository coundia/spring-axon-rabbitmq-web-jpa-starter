package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "RolePermissionRequest", description = "Request payload for RolePermission operations")
public class RolePermissionRequest implements Serializable {

	@Schema(description = "", example = "837086c5-8b6b-4942-b784-714d8fc2737f")
	private String role;

	@Schema(description = "", example = "86aebf1a-9ffd-4a90-9013-4a79f27c151f")
	private String permission;


}
