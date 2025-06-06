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

	@Schema(description = "", example = "b83a524f-37be-4305-b318-f43b12363376")
	private String role;
	@Schema(description = "", example = "6d380197-841b-4019-9320-9753bcc370e3")
	private String permission;

}
