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

	@Schema(description = "", example = "49e2cf23-dbc6-41a6-b301-b6ae829f166b")
	private String role;

	@Schema(description = "", example = "613bdde0-3778-4e31-a6b9-f7a0e82eeb38")
	private String permission;


}
