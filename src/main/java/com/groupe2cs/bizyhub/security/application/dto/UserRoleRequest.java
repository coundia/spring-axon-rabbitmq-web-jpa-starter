package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "UserRoleRequest", description = "Request payload for UserRole operations")
public class UserRoleRequest implements Serializable {

	@Schema(description = "", example = "6655d3f8-3c77-4e4e-9278-31118f53e611")
	private String user;

	@Schema(description = "", example = "c4963550-91e2-462b-a988-c8853e2d5212")
	private String role;


}
