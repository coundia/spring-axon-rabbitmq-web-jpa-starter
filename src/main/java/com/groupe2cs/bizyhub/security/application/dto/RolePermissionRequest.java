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

	@Schema(description = "", example = "d66a28dd-1f0c-4226-81ec-c1468fa2fce1")
	private String role;

	@Schema(description = "", example = "95957d42-eb63-4209-8e35-b02a2684aab5")
	private String permission;


}
