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

	@Schema(description = "", example = "aea50e33-dff9-45fb-9e5f-25c2361700e4")
	private String username;

	@Schema(description = "", example = "22d72444-917f-45d5-8817-d6ca6f89f43e")
	private String password;


}
