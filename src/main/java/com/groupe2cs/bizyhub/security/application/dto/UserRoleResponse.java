package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "UserRoleResponse", description = "Response payload for UserRole")
public class UserRoleResponse implements Serializable {

	@Schema(description = "", example = "")
	private String id;
	@Schema(description = "", example = "")
	private String user;
	@Schema(description = "", example = "")
	private String role;
	@Schema(description = "", example = "")
	private String createdBy;

}
