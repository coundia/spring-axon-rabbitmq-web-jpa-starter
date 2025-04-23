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

	@Schema(description = "", example = "834b8d9b-c1db-4124-86bc-0c484cd6f3d3")
	private String username;

	@Schema(description = "", example = "ca04daf8-864d-45a9-9d58-3ef6b3b7aeb1")
	private String password;


}
