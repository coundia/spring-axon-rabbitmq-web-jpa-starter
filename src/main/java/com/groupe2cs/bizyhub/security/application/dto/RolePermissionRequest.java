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

	@Schema(description = "", example = "f7545e04-5320-4737-bc3d-6bbd0e2dc7bd")
	private String role;

	@Schema(description = "", example = "4bf1fd75-cefc-4dc6-b5f7-e13d665ef0f4")
	private String permission;


}
