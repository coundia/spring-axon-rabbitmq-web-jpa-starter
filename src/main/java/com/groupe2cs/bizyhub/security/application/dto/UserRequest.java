package com.groupe2cs.bizyhub.security.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "UserRequest", description = "Request payload for User operations")
public class UserRequest implements Serializable {

	@Schema(description = "", example = "b0c511ab-60ce-4b58-9f93-d3fcad002eb8")
	private String username;

	@Schema(description = "", example = "95287ecc-845b-4280-9837-c341333c16e7")
	private String password;


}
