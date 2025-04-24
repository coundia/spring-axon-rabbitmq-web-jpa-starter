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

	@Schema(description = "", example = "413b73d6-9001-42a6-86f0-d356963b178e")
	private String username;

	@Schema(description = "", example = "e590a846-ade8-41fc-a4d8-5f083fb911c3")
	private String password;


}
