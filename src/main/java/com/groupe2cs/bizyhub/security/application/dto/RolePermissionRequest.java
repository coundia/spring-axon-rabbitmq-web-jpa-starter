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

	@Schema(description = "", example = "8061e092-046c-40e4-ae8c-64dcce303c58")
	private String role;

	@Schema(description = "", example = "9d534482-d9af-424f-8d6c-1acd59d1f29e")
	private String permission;


}
