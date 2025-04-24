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

	@Schema(description = "", example = "ce9a3fc6-2083-401a-9f8d-095db1a20529")
	private String user;

	@Schema(description = "", example = "26f30769-e38b-41cb-9daf-9346dda488f3")
	private String role;


}
