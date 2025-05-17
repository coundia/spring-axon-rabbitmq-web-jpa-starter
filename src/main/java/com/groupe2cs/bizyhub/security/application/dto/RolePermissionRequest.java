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

	@Schema(description = "", example = "cb8859f9-1193-4583-90dc-6533f4ae6e33")
	private String role;

	@Schema(description = "", example = "b024f099-bb97-4213-afe8-c1dfbdb990ce")
	private String permission;


}
