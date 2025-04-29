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

	@Schema(description = "", example = "b3cc083b-31ce-4471-909b-e4c562f94787")
	private String user;

	@Schema(description = "", example = "42c05dc5-bb54-4051-a7fb-c92f4a602700")
	private String role;


}
