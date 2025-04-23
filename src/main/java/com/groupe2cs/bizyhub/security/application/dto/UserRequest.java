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

	@Schema(description = "", example = "b566a0e0-6d31-4e0c-b0e5-5d99e9bf4b10")
	private String username;

	@Schema(description = "", example = "1d0ad45b-99cd-40cb-a228-b4158b88be6b")
	private String password;


}
