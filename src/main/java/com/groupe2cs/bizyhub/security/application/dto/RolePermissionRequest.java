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

	@Schema(description = "", example = "8e104c28-59f8-4fe2-97a7-49ef0d3c4aaa")
	private String role;

	@Schema(description = "", example = "479cf1d5-9448-4c6b-bc4d-662a5984ed6a")
	private String permission;


}
