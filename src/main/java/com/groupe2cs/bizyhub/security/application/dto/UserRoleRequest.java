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

	@Schema(description = "", example = "faeacbdb-e647-40a2-b19b-e86ac3b6486b")
	private String user;

	@Schema(description = "", example = "d1969831-e4a3-495a-8567-a0ea9be48c73")
	private String role;


}
