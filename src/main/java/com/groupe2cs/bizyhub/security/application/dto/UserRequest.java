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

	@Schema(description = "", example = "aa528779-72a9-461f-9fe1-0e604b046b5e")
	private String username;

	@Schema(description = "", example = "2c38a099-9dde-447f-a127-91cac8f21712")
	private String password;


}
