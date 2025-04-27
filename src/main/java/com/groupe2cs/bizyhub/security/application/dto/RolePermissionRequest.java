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

	@Schema(description = "", example = "8fa61867-9acf-469a-833d-ef896551c166")
	private String role;

	@Schema(description = "", example = "3bdc5537-a992-4a10-9b8e-f8636b9f119c")
	private String permission;


}
