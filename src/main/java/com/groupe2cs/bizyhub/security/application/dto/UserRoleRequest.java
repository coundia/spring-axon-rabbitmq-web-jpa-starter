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

	@Schema(description = "", example = "c968bbae-bb7e-4cd7-bff8-0b9928b720f2")
	private String user;

	@Schema(description = "", example = "aa598fd9-5cc9-409a-a240-260cdca103d9")
	private String role;


}
