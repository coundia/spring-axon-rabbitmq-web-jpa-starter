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

	@Schema(description = "", example = "a1d75024-cbd5-42ae-a0ce-9c89a9cb1802")
	private String username;

	@Schema(description = "", example = "0e6571a1-c721-47c4-81c1-05cbfaa0b86c")
	private String password;


}
