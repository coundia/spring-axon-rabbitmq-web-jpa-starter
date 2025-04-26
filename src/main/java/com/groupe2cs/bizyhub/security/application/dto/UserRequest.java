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

	@Schema(description = "", example = "f7ff0ec9-3dc7-49a1-ba46-dacd32052c63")
	private String username;

	@Schema(description = "", example = "96e38a71-4da2-41e7-a35d-926ff819efef")
	private String password;


}
