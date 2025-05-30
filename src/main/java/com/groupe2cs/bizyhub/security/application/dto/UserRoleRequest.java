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

	@Schema(description = "", example = "7b8f8907-0abd-464e-9002-076e3feac6cc")
	private String user;
	@Schema(description = "", example = "9e08547c-5b9f-4180-be8a-756242863ef0")
	private String role;

}
