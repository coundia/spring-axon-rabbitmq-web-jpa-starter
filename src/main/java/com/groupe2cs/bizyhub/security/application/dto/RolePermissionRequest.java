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

	@Schema(description = "", example = "c2f3d6fe-84f1-44dc-a71c-58697b428972")
	private String role;
	@Schema(description = "", example = "8f06e528-c168-4939-992b-f053d3a07014")
	private String permission;

}
