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

	@Schema(description = "", example = "24487997-0c59-4bb1-9b51-d7a501d49b95")
	private String role;

	@Schema(description = "", example = "bd49956e-29bd-4ea9-8a84-c4cc9a739408")
	private String permission;


}
