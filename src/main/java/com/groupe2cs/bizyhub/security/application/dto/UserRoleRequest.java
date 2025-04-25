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

	@Schema(description = "", example = "a37988a2-5bf1-401f-87fa-703459482267")
	private String user;

	@Schema(description = "", example = "7095b243-f451-4e54-bbf2-4b906870e268")
	private String role;


}
