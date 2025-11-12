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

	@Schema(description = "", example = "04899ad0-9aa7-4edf-a8af-d28e7dd27ae4")
	private String name;

}
