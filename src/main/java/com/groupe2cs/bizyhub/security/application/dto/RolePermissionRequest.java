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

	@Schema(description = "", example = "479086b8-0904-495a-b59e-48bbf154a471")
	private String role;
	@Schema(description = "", example = "eda89f42-735f-4395-af3b-a0b71dce163b")
	private String permission;

}
