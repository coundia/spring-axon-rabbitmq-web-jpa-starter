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

	@Schema(description = "", example = "49dfb9fb-0841-4dcb-9730-2e42cd6e6194")
	private String role;

	@Schema(description = "", example = "76754397-645d-4c04-bb12-90cfda2730b4")
	private String permission;


}
