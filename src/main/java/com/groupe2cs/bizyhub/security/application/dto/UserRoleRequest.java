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

	@Schema(description = "", example = "6b24ee44-8d72-4c20-945d-b687c690d8cd")
	private String user;

	@Schema(description = "", example = "09fe418a-38f1-4a6e-8e69-61f4e478c433")
	private String role;


}
