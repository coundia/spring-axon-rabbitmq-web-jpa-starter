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

	@Schema(description = "", example = "dff5fd73-7052-420b-8abd-2cf104ca883c")
	private String user;

	@Schema(description = "", example = "034d01f9-957e-4bca-b99f-5763e7e73294")
	private String role;


}
