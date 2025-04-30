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

	@Schema(description = "", example = "108e9447-f35c-47a1-949f-ebdefca17dc2")
	private String username;

	@Schema(description = "", example = "e7c4b7ca-13c7-459d-b2a8-5a5a39d11206")
	private String password;


}
