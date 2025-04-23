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

	@Schema(description = "", example = "adcf82e0-d4c2-4f8c-bd5a-63d4fc4e857c")
	private String role;

	@Schema(description = "", example = "c5a7f600-f631-41ca-902c-e82e8571c68d")
	private String permission;


}
