package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "RoleRequest", description = "Request payload for Role operations")
public class RoleRequest implements Serializable {

	@Schema(description = "", example = "a9d9035c-9ad6-4126-b05a-f500600c3e2f")
	private String name;


}
