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

	@Schema(description = "", example = "f5d4a870-d800-46fd-878c-dce8e79a90cc")
	private String username;

	@Schema(description = "", example = "eff6b46a-e278-417f-bd69-a696b4a722c7")
	private String password;


}
